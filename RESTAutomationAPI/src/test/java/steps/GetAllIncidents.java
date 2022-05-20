package steps;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidents {

	public static RequestSpecification reqSpec;
	public static Response response;

	@Given("base URI and it's details are set")
	public void setURI() {

		RestAssured.baseURI = "https://dev123430.service-now.com/api/now/table/incident";
	}

	@And("basic authentication and credentials for validations passed")
	public void setBaseAuthenticate() {

		RestAssured.authentication = RestAssured.basic("admin", "Integral@29");

	}

	@Then("list of params passed to sort out the response")
	public void sortResponseDetails() {

		Map<String, String> allValues = new HashMap<String, String>();

		allValues.put("category", "software");
		allValues.put("sysparm_fields", "number, sys_id, category");

		response = RestAssured
				.given()
				.accept(ContentType.JSON)
				.queryParams(allValues)
				.get();

	}

	@When("result is produced it should show the status code (.*)$")
    public void getResutAndStatusCode(String code) {
		
		 response
		.then()
		 .assertThat()
		 .statusCode(Integer.parseInt(code))
		 .extract()
		 .response();
		 
	
		
	}

	@But("seperate response also printed in entire result")
    public void getAllResultDetails() {

		response.prettyPrint();
	}
}
