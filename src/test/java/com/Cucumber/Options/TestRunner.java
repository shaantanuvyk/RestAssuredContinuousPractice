package com.Cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/Locations1",
		glue={"stepDefinitions"}
		//,tags="@SanityTest"
//		plugin ="html:target/jsonReports/cucumber-report.html",
		)

public class TestRunner 
{
	
}

