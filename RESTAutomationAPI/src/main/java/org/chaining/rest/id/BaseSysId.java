package org.chaining.rest.id;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseSysId {
	
	
	public static String sys_id;	
	
	public static RequestSpecification reqSpec;
	
	public static Response response;
	
	@BeforeSuite
	public void initialSetUp() {
		
        RestAssured.baseURI = "https://dev123430.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "Integral@29");
		
		reqSpec = RestAssured.given().log().all();
		
		
	}

	
	@AfterMethod
	public void afterResponseLog() {
		
		
		response.then().log().all();
		
	}
}
