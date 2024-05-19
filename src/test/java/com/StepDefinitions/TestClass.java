package com.StepDefinitions;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class TestClass 
{
	String URL = "https://rahulshettyacademy.com";
	@Test
	public void getLocation()
	{
		Response response = given().baseUri(URL).param("key", "qaclick123").param("place_id", "5e1260413bb6de74bc1bef6a9994f2c9").
							when().get("maps/api/place/get/json").
							then().extract().response();
		
		System.out.println("Status Code is: " +response.statusCode());
		
		String res = response.asString();
		
		JsonPath jPath = new JsonPath(res);
		String phoneNumber = jPath.get("phone_number");
		System.out.println("Phone Number is: " +phoneNumber);
		
	}
}
