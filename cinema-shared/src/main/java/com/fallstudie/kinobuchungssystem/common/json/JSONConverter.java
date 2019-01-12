package com.fallstudie.kinobuchungssystem.common.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JSONConverter
{
    static NullKeySerializer nullKeySerializer = new NullKeySerializer();

    private JSONConverter( )
    {
    }

    public static String toJSON ( Object object ) throws JsonProcessingException
    {
        String str = "";
        ObjectMapper om = new ObjectMapper();
        om.getSerializerProvider().setNullKeySerializer(nullKeySerializer);
        str = om.writeValueAsString(object);
        return str;
    }

    public static Object fromJSON ( String json, Class<?> javaClass ) throws IOException
    {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object obj = om.readValue(json, javaClass);
        return obj;
    }

    public static Object fromJSONList ( String json, Class<?> javaClass ) throws IOException
    {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object obj = om.readValue(json, om.getTypeFactory().constructCollectionType(List.class, javaClass));
        return obj;
    }

    public static Object fromJSON ( String json, TypeReference<?> typeReference ) throws IOException
    {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object obj = om.readValue(json, typeReference);
        return obj;
    }

    static class NullKeySerializer extends StdSerializer<Object>
    {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        public NullKeySerializer( )
        {
            this(null);
        }

        public NullKeySerializer( Class<Object> t )
        {
            super(t);
        }

        @Override
        public void serialize ( Object value, JsonGenerator jgen, SerializerProvider provider ) throws IOException, JsonGenerationException
        {
            jgen.writeFieldName("");

        }
    }

}
