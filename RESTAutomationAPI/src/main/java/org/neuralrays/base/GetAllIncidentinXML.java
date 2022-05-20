package org.neuralrays.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentinXML {

	
	@Test
	public void getIncidentsXML() {
    	
    	
    	Map <String, String> allParams = new HashMap<String, String>();
    	
    	allParams.put("category", "software");
    	
    	allParams.put("contact_type", "phone");
    	
    	allParams.put("sysparm_fields", "sys_id,number,task_effective_number,severity,category,contact_type");
    	
    	RestAssured.baseURI = "https://dev125755.service-now.com/api/now/table/incident";
    	
    	RestAssured.authentication = RestAssured.basic("admin", "Integral_29");
    	
    	Response response =  RestAssured
    			.given()
    			.accept(ContentType.XML)
    			.queryParams(allParams)
    		    .get();
    	
    	System.out.println(response.statusCode());
		
    	response.prettyPrint();
		
    	XmlPath xmlPath = response.xmlPath();
    	
        List<String> list = xmlPath.getList("result.sys_id");
    	
    	System.out.println(list.size());
    	
    	for (String num : list) {
    		
    		System.out.println(num);
				
		}
    	
   
		
		
	}
}
