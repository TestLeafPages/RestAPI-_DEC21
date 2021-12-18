package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString {

	@Test
	public void createIncidentWithoutBody(String roleNo) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev117006.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\": \"create incident with body json\",\"category\": \""+roleNo+"\"}")
				.post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
