package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {

	@DataProvider(name = "fetchData")
	public String[] getData() {
		//No of row -> no of data
		//No of Column -> no of value
		String[] data = new String[2];
		//1st row
		data[0] = "./data/CreateIncident1.json";
		//2nd row
		data[1] = "./data/CreateIncident2.json";
		
		return data;
		
	}
	
	@Test(dataProvider = "fetchData")
	public void createIncidentWithBody(String filePath) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev113226.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: request type (get) { ctrl+2 , l }
		
		File file = new File(filePath);
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(file)
				.post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		
		


	}

}
