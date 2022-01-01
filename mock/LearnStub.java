package mock.stub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnStub {

/*	@BeforeMethod
	public void stubSample() {
		stubFor(post("/api/now/table/incident")
				.willReturn(aResponse()
				.withStatus(201)
				.withHeader("content-type", "application/json")
				.withBody("{\"result\": {\"sys_id\": \"32c399111b7001106faa2134604bcba0\",\"category\": \"hardware\", \"number\": \"INC12344\"}}")
						));
	}*/
	
	
	@Test
	public void createIncidentWithoutBody() {
		
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
