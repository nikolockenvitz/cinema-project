package com.fallstudie.cinemasystem.common.urlhelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fallstudie.cinemasystem.common.exception.GeneralException;

public class UrlCallHelper
{

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlCallHelper.class);

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String SOAP_FAULT_REGEX = "(?:[\\s|\\S]*<faultstring[\\s|\\S]*>)([\\s|\\S]*)(?:</faultstring>)";

    private static final Pattern SOAP_FAULT_PATTERN = Pattern.compile(SOAP_FAULT_REGEX);

    public UrlCallHelper( )
    {
    }

    public String sendGet ( String urlString, Map<String, String> parameters, String mediaType ) throws IOException, GeneralException
    {
        String urlParameters = createParameters(parameters);
        String newUrlString = urlString + "?" + urlParameters;
        URL url = new URL(newUrlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // add request header
        addRequestHeader(con, "GET", mediaType);

        int responseCode = con.getResponseCode();
        if ( LOGGER.isDebugEnabled() )
        {
            LOGGER.debug("\nSending 'GET' request to URL : " + url);
            LOGGER.debug("Get parameters : " + urlParameters);
            LOGGER.debug("Response Code : " + responseCode);
        }

        StringBuilder response = readResponse(con);

        return response.toString();

    }

    public String sendGet ( URL url, String mediaType ) throws IOException, GeneralException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // add request header
        addRequestHeader(con, "GET", mediaType);

        int responseCode = con.getResponseCode();
        if ( LOGGER.isDebugEnabled() )
        {
            LOGGER.debug("\nSending 'GET' request to URL : " + url);
            LOGGER.debug("Response Code : " + responseCode);
        }

        StringBuilder response = readResponse(con);

        return response.toString();

    }

    public String sendPost ( URL url, Map<String, String> parameters, String mediaType ) throws IOException, GeneralException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // add request header
        addRequestHeader(con, "POST", mediaType);

        String urlParameters = createParameters(parameters);

        // Send post request
        sendPostRequest(con, urlParameters);

        int responseCode = con.getResponseCode();
        if ( LOGGER.isDebugEnabled() )
        {
            LOGGER.debug("\nSending 'POST' request to URL : " + url);
            LOGGER.debug("Post parameters : " + urlParameters);
            LOGGER.debug("Response Code : " + responseCode);
        }

        StringBuilder response = readResponse(con);

        return response.toString();

    }

    public String sendPost ( URL url, String body, String mediaType ) throws IOException, GeneralException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // add request header
        addRequestHeader(con, "POST", mediaType);

        // Send post request
        sendPostRequest(con, body);

        int responseCode = con.getResponseCode();
        if ( LOGGER.isDebugEnabled() )
        {
            LOGGER.debug("\nSending 'POST' request to URL : " + url);
            LOGGER.debug("Post parameters : " + body);
            LOGGER.debug("Response Code : " + responseCode);
        }

        StringBuilder response = readResponse(con);

        return response.toString();

    }

    public String sendPut ( URL url, Map<String, String> parameters, String mediaType ) throws IOException, GeneralException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // add request header
        addRequestHeader(con, "PUT", mediaType);

        String urlParameters = createParameters(parameters);

        // Send post request
        sendPutRequest(con, urlParameters);

        int responseCode = con.getResponseCode();
        if ( LOGGER.isDebugEnabled() )
        {
            LOGGER.debug("\nSending 'PUT' request to URL : " + url);
            LOGGER.debug("PUT parameters : " + urlParameters);
            LOGGER.debug("Response Code : " + responseCode);
        }

        StringBuilder response = readResponse(con);

        return response.toString();

    }

    private StringBuilder readResponse ( HttpURLConnection con ) throws IOException, GeneralException
    {

        StringBuilder response = new StringBuilder();
        InputStream inStream = HttpURLConnection.HTTP_OK == con.getResponseCode() ? con.getInputStream() : con.getErrorStream();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inStream)))
        {
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
        }
        if ( HttpURLConnection.HTTP_OK != con.getResponseCode() )
        {
            throwException(response);
        }
        return response;
    }

    private void throwException ( StringBuilder response ) throws GeneralException
    {
        String responseString = response.toString();
        if ( StringUtils.startsWith(responseString, "<!doctype") )
        {
            throw new GeneralException("Experiencing difficulties while reading the response of datawarehouse!");
        } else if ( isSoapFault(responseString) )
        {
            responseString = getSoapFaultMessage(responseString);
        }
        throw new GeneralException(responseString);
    }

    private void sendPostRequest ( HttpURLConnection con, String urlParameters ) throws IOException
    {
        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        Writer wr = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
        wr.write(urlParameters);
        wr.flush();
        wr.close();
    }

    private void sendPutRequest ( HttpURLConnection con, String urlParameters ) throws IOException
    {
        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
        Writer wr = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
        wr.write(urlParameters);
        wr.flush();
        wr.close();
    }

    private void addRequestHeader ( HttpURLConnection con, String method, String mediaType ) throws ProtocolException
    {
        con.setRequestMethod(method);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", mediaType + "; charset=utf-8");
    }

    private String createParameters ( Map<String, String> parameters )
    {
        StringBuilder result = new StringBuilder();
        for ( Entry<String, String> entry : parameters.entrySet() )
        {
            result.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        if ( result.length() > 0 )
        {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private String getSoapFaultMessage ( String message )
    {
        if ( null != message )
        {
            Matcher matcher = SOAP_FAULT_PATTERN.matcher(message);
            if ( matcher.find() )
            {
                return matcher.group(1);
            }
        }
        return message;
    }

    private boolean isSoapFault ( String message )
    {
        if ( null != message )
        {
            Matcher matcher = SOAP_FAULT_PATTERN.matcher(message);
            if ( matcher.find() )
            {
                return true;
            }
        }
        return false;
    }
}
