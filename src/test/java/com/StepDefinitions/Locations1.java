package com.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.Resources.Utilities;

public class Locations1 extends Utilities
{
	RequestSpecification request;
	static Response response;
	int StatusCode;
	static String PlaceID;

	@Given("Verify user can add a location using {string}")
	public void verify_user_can_add_a_location_using(String URL) throws IOException 
	{
		request = given().baseUri(GlobalProperties1(URL)).queryParam("key", "qaclick123").header("Content-Type","application/json").
				body("{\r\n"
						+ "    \"location\": {\r\n"
						+ "        \"lat\": -21.06199,\r\n"
						+ "        \"lng\": -23.061958\r\n"
						+ "    },\r\n"
						+ "    \"accuracy\": 88,\r\n"
						+ "    \"name\": \"Guruvayur Electricals Ltd.\",\r\n"
						+ "    \"phone_number\": \"+91-9028288206\",\r\n"
						+ "    \"address\": \"156, Kansai Section\",\r\n"
						+ "    \"types\": [\r\n"
						+ "        \"Driving\",\r\n"
						+ "        \"Photography\",\r\n"
						+ "        \"Cricket\",\r\n"
						+ "        \"Travelling\"\r\n"
						+ "    ],\r\n"
						+ "    \"website\": \"www.guruvayurelectricals.com\",\r\n"
						+ "    \"language\": \"Malyalum\"\r\n"
						+ "}");
	}

	@When("using resource {string} and method as {string}")
	public void using_resource_and_method_as(String Resource, String Method) throws IOException 
	{
		if(Method.equalsIgnoreCase("post"))
		{
			response = request.
		    post(GlobalProperties1(Resource)).
		    then().extract().response();
		}
		else if(Method.equalsIgnoreCase("get"))
		{
			response = request.
		    get(GlobalProperties1(Resource)).
		    then().log().all().extract().response();
		}
		
		else if(Method.equalsIgnoreCase("put"))
		{
			response = request.
		    put(GlobalProperties1(Resource)).
		    then().extract().response();
		}
		
		else if(Method.equalsIgnoreCase("delete"))
		{
			response = request.
		    delete(GlobalProperties1(Resource)).
		    then().extract().response();
		}
	}
	
	@Then("status should be {string} with status code as {int}")
	public void status_should_be_with_status_code_as(String Status, int StatusCode) 
	{
		int status = response.statusCode();
		System.out.println("Status Line" +response.statusLine());
		assertEquals(StatusCode, status);
	}

	@Then("get the value {string}")
	public void get_the_value(String value) 
	{
		
		PlaceID= jsonPath(response, value);
		System.out.println("VALUE: " +PlaceID);
	}
	
	//-----------------------------------------------------------------------------------------------------------------//
	
	@Given("Verify user can be fetched using {string}")
	public void verify_user_can_be_fetched_using(String string) throws IOException 
	{
		request = given().baseUri(GlobalProperties1("BaseURL")).queryParam("key", "qaclick123").queryParam("place_id", PlaceID).header("Content-Type","application/json");
	}

	
	@Then("get the value {string} and {string}")
	public void get_the_value_and(String Name, String PhoneNumber) 
	{
		String name= jsonPath(response, Name);
		String phoneNumber= jsonPath(response, PhoneNumber);
		
		System.out.println("Name: " +name+ " and Phone Number: " +phoneNumber);
	} 
}
