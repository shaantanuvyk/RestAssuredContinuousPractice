package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks 
{
	Locations1 locations1 = new Locations1();
	
	@Before("@UpdatePlace")
	public void beforeUpdateLocation() throws IOException
	{
		beforeGetLocation();
	}
	
	@Before("@DeletePlace")
	public void beforeDeleteLocation() throws IOException
	{
		beforeGetLocation();
	}
	
	
	@Before("@GetPlace1")
	public void beforeGetLocation() throws IOException
	{
		locations1.verify_user_can_add_a_location_using("BaseURL");
		locations1.using_resource_and_method_as("AddResource", "post");
		locations1.get_the_value("place_id");
	}
}
