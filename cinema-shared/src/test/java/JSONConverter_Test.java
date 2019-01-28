
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fallstudie.cinemasystem.common.json.JSONConverter;
import com.fallstudie.cinemasystem.common.transferobject.ActorTo;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONConverter_Test {
	ActorTo testActorTo = null;
	String testStringConverterToJSON = null;
	String testStringFromJSONList = null;
	List<ActorTo> testActorToList = null;
	
  @Before
  public void initialize() {
	testActorTo = new ActorTo();
	testActorTo.setId(1);
	testActorTo.setBirthdate("01.01.1970");
	testActorTo.setFirstname("Vorname");
	testActorTo.setLastname("Nachname");
	
	testActorToList = new ArrayList();
	testActorToList.add(testActorTo);
	testActorToList.add(testActorTo);
	
	testStringConverterToJSON = "{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}";
	testStringFromJSONList = "[{\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}, {\"id\":1,\"firstname\":\"Vorname\",\"lastname\":\"Nachname\",\"birthdate\":\"01.01.1970\"}]";
  }
  
  @Test
  public void testToJSON() {
	  try {
		assertThat(testStringConverterToJSON, equalTo(JSONConverter.toJSON(testActorTo)));
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @Test
  public void testFromJSON() {
	  try {
		assertThat(testActorTo, equalTo(JSONConverter.fromJSON(testStringConverterToJSON, ActorTo.class)));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @Test
  public void testFromJSONList() {
	  try {
		assertThat(testActorToList, equalTo(JSONConverter.fromJSONList(testStringFromJSONList, ActorTo.class)));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

}
