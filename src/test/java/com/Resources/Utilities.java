package com.Resources;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Utilities
{
	
	
	
	
	public String readPropertyFile(String Key) throws IOException
	{
		//FileReader will read data from the created file byte by byte
		FileReader file = new FileReader("C:\\Users\\ACER\\RestAssuredContPractice\\RestAssured\\src\\test\\java\\com\\Resources\\Global.properties");
		
		//Properties class provides the methods to accept the stream of characters
		Properties prop = new Properties();
		//load method actually load the file in which the data (stream of characters) is present
		prop.load(file);
		
		return prop.getProperty(Key);
	}
	
	
	
	
}
