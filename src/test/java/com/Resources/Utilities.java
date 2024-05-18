package com.Resources;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Utilities
{
	public void readPropertyFile() throws IOException
	{
		//FileReader will read data from the created file byte by byte
		FileReader file = new FileReader("C:\\Users\\ACER\\RestAssuredContPractice\\RestAssured\\src\\test\\java\\com\\Resources\\Global.properties");
		
		Properties prop = new Properties();
		prop.load(file);
		
		String Domain= prop.getProperty("Domain");
		
		
		System.out.println("The Domain = " +Domain);
	}
	
	
	
	
}
