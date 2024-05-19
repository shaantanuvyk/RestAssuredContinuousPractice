package com.StepDefinitions;

import org.junit.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;


public class TestClass 
{
	RequestSpecification request;
	//ResponseSpecification responsesb;
	String URL = "https://rahulshettyacademy.com";
	@Test
	public void getLocation()
	{
		RequestSpecification requestsb = new RequestSpecBuilder().setBaseUri("https://dummyjson.com").addParam("", "").build();
		request=given().spec(requestsb);
		
		
		Response response = request.
							when().get("user").
							then().extract().response();
		
		System.out.println("Status Code is: " +response.statusCode());
		
		String res = response.asString();
		
		JsonPath jPath = new JsonPath(res);
		int id = jPath.get("users.id[0]");
		System.out.println("Phone Number is: " +id);
		
	}
}
