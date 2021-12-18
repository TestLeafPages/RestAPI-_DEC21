package basic;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentWithQueryParam {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("sysparm_fields", "number,sys_id,category");
		queryParams.put("category", "software");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("ContentType", "application/json");
		headers.put("Authorization", "Basic YWRtaW46VHVuYUAxMjM=");// base64
//		step3: request type (get)
		Response response = RestAssured.given()
				.headers(headers)
				.queryParams(queryParams)
				.get();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
