package basic;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentwithCookies {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				.given()
				.cookie("JSESSIONID","3884C74B31ED0E471DD36D3AE6D38662")
				.get();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		Map<String, String> AllCookies = response.getCookies();
		//for(datatype temp : collection_object)
		for (Entry<String, String> eachEntry : AllCookies.entrySet()) {
			System.out.println(eachEntry.getKey()+" : "+eachEntry.getValue());
		}
		
		


	}

}
