package mock.stub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnTemp {
//java -jar wiremock-jre8-standalone-2.26.3.jar --global-response-templating
	
	@Test
	public void createIncidentWithoutBody() {
		
		RestAssured.baseURI = "http://localhost:8080/testleaf/traning/course";
		Response response = RestAssured
				.given()
				.queryParam("course_name", "DevOps")
				.queryParam("type", "offline")
				.contentType(ContentType.JSON)
				.get();
		response.prettyPrint();


	}

}
