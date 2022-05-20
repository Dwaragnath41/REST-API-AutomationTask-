package org.rest.api.learn;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {
	
	
	
	@Test
	public void getIncidents() {
		
		RestAssured.baseURI = "https://dev112614.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "Pv=b^B1u1ZQe");
		
		Response response = RestAssured.get();
		
		System.out.println(response.statusCode());
		
		response.prettyPrint();
		
	}
}
