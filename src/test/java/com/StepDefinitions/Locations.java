package com.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Locations 
{
	
	RequestSpecification requestsb;
	ResponseSpecification responsesb;
	static Response response;
	String URL = "https://rahulshettyacademy.com";
	String getResource = "";
	String addResource = "maps/api/place/add/json";
	
	@Given("Verify sending the get request")
	public void verify_sending_the_get_request() {
		
	    requestsb = given().baseUri(URL).queryParam("key","qaclick123").queryParam("place_id","5e1260413bb6de74bc1bef6a9994f2c9");
	}	

	@When("using {string} and {string}")
	public void using_and(String string, String string2) {
		response = requestsb.
    			when().get("maps/api/place/get/json").
    			then().extract().response();
		
		System.out.println("Response is: " +response);
	}

	@Then("status of the response should be {int}")
	public void status_of_the_response_should_be(int StatusCode) {
	   
		System.out.println("Status Code is: " +response.statusCode());
		assertEquals(response.statusCode(), StatusCode);
		
	}
}
