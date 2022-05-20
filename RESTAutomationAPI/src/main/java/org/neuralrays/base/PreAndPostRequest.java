package org.neuralrays.base;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class PreAndPostRequest {

	
	@Test
	public void GetAllDetails() {
		
		Map <String, String> allParams = new HashMap<String, String>();
    	
    	allParams.put("category", "software");
    	
    	allParams.put("contact_type", "phone");
    	
    	allParams.put("sysparm_fields", "sys_id,number,task_effective_number,severity,category,contact_type");
    	
    	RestAssured.baseURI = "https://dev121425.service-now.com/api/now/table/incident";
    	
    	RestAssured.authentication = RestAssured.basic("admin", "Integral_29");
    	
    	Response response =  RestAssured
    			.given()
    			.log()
    			.all()
    			.accept(ContentType.JSON)
    			.queryParams(allParams)
    		    .get();
    	
    	
    	
       int statusCode = response.getStatusCode();
		
       String statusLine = response.getStatusLine();
		
       long time = response.getTime();
       
       System.out.println(time);
       
       ResponseBody body = response.getBody();
       
    //   System.out.println(body);

	  response.prettyPrint();
	
	}
}
