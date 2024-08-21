package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.Resources.Utilities;

public class Locations extends Utilities
{	
	public static RequestSpecification requestsb;
	public static RequestSpecification request;
	static Response response;

	@Given("Verify sending the get request {string}")
	public void verify_sending_the_get_request(String baseURL) throws IOException {
		
	    requestsb = new RequestSpecBuilder().setBaseUri(readProperty(baseURL)).build();
	    		//.addParam("key","qaclick123").addParam("place_id","5e1260413bb6de74bc1bef6a9994f2c9").build();
	    request=given().spec(requestsb);
	    		//queryParam("key","qaclick123").queryParam("place_id","5e1260413bb6de74bc1bef6a9994f2c9");
	    System.out.println("baseURL is ===========" +readProperty(baseURL));
	    
	}	

	@When("using {string} and {string}")
	public void using_and(String resource, String methodType) throws IOException {
		System.out.println("resource is ===========" +readProperty(resource));
		
		response = given().spec(requestsb).
    			when().get(readProperty(resource)).
    			then().extract().response();
		
		System.out.println("Response is: " +response);
	}

	@Then("status of the response should be {int}")
	public void status_of_the_response_should_be(int StatusCode) {
	   
		System.out.println("Status Code is: " +response.statusCode());
		assertEquals(response.statusCode(), StatusCode);
		
	}
	
	@Then("get the {string}")
	public void get_the(String Value) {
		
		String result = jsonPath(response, Value);
		System.out.println("ID is====== " +result);
		assertEquals(1, Integer.parseInt(result));
	}
}
