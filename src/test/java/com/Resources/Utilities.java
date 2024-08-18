package com.Resources;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utilities
{
	public String jsonPath(Response response, String Keyword)
	{
		String res = response.asString();
		JsonPath jpath = new JsonPath(res);
		String result = jpath.get(Keyword).toString();
		return result;
	}
	
	
	public String readProperty(String Key) throws IOException
	{
		//FileReader will read data from the created file byte by byte
		FileReader file = new FileReader("C:\\Users\\ACER\\RestAssuredContPractice\\RestAssured\\src\\test\\java\\com\\Resources\\Global.properties");
		
		//Properties class provides the methods to accept the stream of characters
		Properties prop = new Properties();
		
		//load method actually load the file in which the data (stream of characters) is present
		prop.load(file);
		
		return prop.getProperty(Key);
	}
	
	
	public String JsonPath1(Response responseResult, String jPath1)
	{
		//Getting the respopnse body as String
		String response = responseResult.asString();
		
		//Creating a JsonPath object
		JsonPath jpath1 = new JsonPath(response);
		
		//Creating a String to store the value required/passed through the script
		String result = jpath1.get(jPath1);
		
		return result; 
	}
	
	public String GlobalProperties1(String key) throws IOException
	{
		FileReader filereader = new FileReader("C:\\Users\\ACER\\RestAssuredContPractice\\RestAssured\\src\\test\\java\\com\\Resources\\Global.properties");
		
		Properties prop = new Properties();
		
		prop.load(filereader);
		
		return prop.getProperty(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
