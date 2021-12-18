package learnassert;

import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

public class CreateIncidentWithVerfySchema {

	@Test
	public void createIncidentWithoutBody() {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		
		
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\": \"create incident with body json\",\"category\": \"hardware\"}")
				.post()
				.then()
				.assertThat()
				//path, value
				.body(matchesJsonSchema(new File("./data/CreateIncidentSchema.json")))
				.extract().response();
		
				
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
