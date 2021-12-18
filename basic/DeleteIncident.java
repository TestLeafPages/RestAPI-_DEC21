package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (delete) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.pathParam("sysID", "460b40892f513010a99d857cf699b6d2")
				.delete("{sysID}");
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
