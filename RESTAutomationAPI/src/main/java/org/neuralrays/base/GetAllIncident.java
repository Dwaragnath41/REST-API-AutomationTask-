package org.neuralrays.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncident {
	
	    @Test
		public void getIncidents() {
	    	
	    	
	    	Map <String, String> allParams = new HashMap<String, String>();
	    	
	    	allParams.put("category", "software");
	    	
	    	allParams.put("contact_type", "phone");
	    	
	    	allParams.put("sysparm_fields", "sys_id,number,task_effective_number,severity,category,contact_type");
	    	
	    	RestAssured.baseURI = "https://dev121425.service-now.com/api/now/table/incident";
	    	
	    	RestAssured.authentication = RestAssured.basic("admin", "Integral_29");
	    	
	    	Response response =  RestAssured
	    			.given()
	    			.accept(ContentType.JSON)
	    			.queryParams(allParams)
	    		    .get();
	    	
	    	System.out.println(response.statusCode());
			
	    	response.prettyPrint();
			
	    	JsonPath jsonPath = response.jsonPath();
	    	
	        List<String> list = jsonPath.getList("result.sys_id");
	    	
	    	System.out.println(list.size());
	    	
	    	for (String num : list) {
	    		
	    		System.out.println(num);
					
			}
	    	
	   
			
			
		}
		
		
		
		
	
	

}
