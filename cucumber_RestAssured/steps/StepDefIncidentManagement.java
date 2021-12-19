package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefIncidentManagement {
	
	private Response response;
	
	@Given("set the endpoint")
	public void inItEndpoint() {
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
	}
	
	@And("set up the basic auth with valid credential")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	@When("send the post request")
	public void createIncident() {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
	}
	
	@When("send the post request with body as {string} and {string}")
	public void createIncidentWithBody(String desc,String category) {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\": \""+desc+"\",\"category\": \""+category+"\"}")
				.post();
				
	}
	
//	@And("verify the status code as (.*)$")
	@And("verify the status code as {int}")
	public void verfystatusCode(int code) {
		response
		.then()
		.statusCode(code)
		.extract()
		.response();
	}
	
	@And("verify the response body contains contentType as (.*)$")
	public void verfycontentType(String type) {
		if(type.toLowerCase().contains("json")) {
			response
			.then()
			.contentType(ContentType.JSON)
			.extract()
			.response();
		} else if (type.toLowerCase().contains("xml")) {
			response
			.then()
			.contentType(ContentType.XML)
			.extract()
			.response();
		} else {
			throw new RuntimeException("ContentType not matching");
		}
		response.prettyPrint();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}









