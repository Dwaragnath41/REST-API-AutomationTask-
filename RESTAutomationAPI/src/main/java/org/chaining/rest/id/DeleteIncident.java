package org.chaining.rest.id;

import org.testng.annotations.Test;

public class DeleteIncident extends BaseSysId {
	
	
	@Test(dependsOnMethods = "org.chaining.rest.id.GetIncident.getIncident")
    public void deleteSelectIncident() {
		
		response = reqSpec.delete(sys_id);
		
		System.out.println(response.getStatusCode());
		
		response.prettyPrint();
		
		
		
		
	}
}
