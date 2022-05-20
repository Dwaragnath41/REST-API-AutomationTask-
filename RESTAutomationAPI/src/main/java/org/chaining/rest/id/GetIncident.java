package org.chaining.rest.id;



import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class GetIncident extends BaseSysId{
	
	
	@Test
	public void getIncident() {
		
		response = reqSpec.get();
		
		JsonPath jsonpath = response.jsonPath();
		
		List<String> lastSysId = jsonpath.getList("result.sys_id");
		
		sys_id = lastSysId.get(0);
		
		System.out.println(sys_id);
		
    

	   
	}
}
