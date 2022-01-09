package graphql;

import org.testng.annotations.Test;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class RunGraphQL {

	@Test
	public void createIncidentWithoutBody() {
		
		
		String jsonBody = "{\r\n" + 
				"  viewer {\r\n" + 
				"    login\r\n" + 
				"  }\r\n" + 
				"  repository(name: \"Leaftaps\", owner: \"SarathTL\") {\r\n" + 
				"    createdAt\r\n" + 
				"    id\r\n" + 
				"    owner {\r\n" + 
				"      id\r\n" + 
				"      avatarUrl\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"";
		
		
		RestAssured.baseURI = "https://api.github.com/graphql";
		Response response = RestAssured
				.given()
				.header(new Header("Authorization", "Bearer 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"))
				.log().all()
				.contentType(ContentType.JSON)
				.body(convertJsonToString(jsonBody))
				.post();
		response.prettyPrint();
	}
	
	
	private String convertJsonToString(String json) {
		JSONObject obj = new JSONObject();
		obj.put("query", json);
		return obj.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
