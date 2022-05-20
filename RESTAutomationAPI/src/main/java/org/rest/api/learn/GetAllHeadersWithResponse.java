package org.rest.api.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class GetAllHeadersWithResponse {
	
	
	
	@Test
	public void getAllHeaderDetails() {
		
		
		List<Header> headers = new ArrayList<Header>();
		
		headers.add(new Header("Authorization", "Basic YWRtaW46SW50ZWdyYWxfMjk="));
	    headers.add(new Header("Accept", "application/xml"));
	    
	    Headers allheaders = new Headers(headers);
		
		Map <String, String> params  =  new HashMap<String, String> ();
		
		params.put("category", "software");
		params.put("sysparm_fields", "number,sys_id,category");
		
		
		RestAssured.baseURI = "https://dev107021.service-now.com/api/now/table/incident";
		
	    Response response = RestAssured
	         .given()
	         .log()
	         .all()
	         .queryParams(params)
	         .headers(allheaders)
	         .get();
	    
	    
	    System.out.println(response.getStatusCode());
	    
	    response.prettyPrint();
	    
	    
	    Map<String, String> cookies = response.getCookies();
	    
	    for (Entry<String, String> cookie : cookies.entrySet()) {
	    	
	    	System.out.println(cookie.getKey());
			System.out.println(cookie.getValue());
			
			System.out.println("******************");
		}
	         
	         
	         
	         
		
		
		
	}

}
