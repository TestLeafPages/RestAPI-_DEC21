package learnassert;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncident {

	@Test
	public void getIncident() {
		//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
		//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		//		step3: request type (get) { ctrl+2 , l }
		RestAssured.given()
				.queryParam("sysparm_fields", "sys_id,number")
//				.queryParam("sysparm_limit", "10")
				.get()
				.then()
//				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.body("result.number", hasItem("INC0000051"))
				.extract()
				.response()
				.prettyPrint()
				;

//		//		step4: print response body
//		response.prettyPrint();
//		//		step5: print status code
//		System.out.println(response.statusCode());




	}

}
