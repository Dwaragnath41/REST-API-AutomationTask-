package org.rest.api.learn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithJsonParse {
	
	
	
	@Test
	public void getIncidents() {
		
		
		Map<String, String> allValues = new HashMap<String, String>();
		
		allValues.put("category", "software");
		allValues.put("sysparm_fields", "number, sys_id, category");
		
		RestAssured.baseURI = "https://dev112614.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin", "Pv=b^B1u1ZQe");
		
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.queryParams(allValues)
				.get();
		
		
		
		System.out.println(response.statusCode());
		
		response.prettyPrint();
		
	/*	JsonPath jsonPath = response.jsonPath();
		
		List<String> list = jsonPath.getList("result.sys_id");
		
		System.out.println(list.size());
		
		for (String values : list) {

			System.out.println(values);
			
		}    */
		
	}
}
