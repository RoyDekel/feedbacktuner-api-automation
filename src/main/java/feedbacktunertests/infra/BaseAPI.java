package feedbacktunertests.infra;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class BaseAPI {
	
	RestAssured ra = new RestAssured();
	
	
	public String getBasePath() {
		return RestAssured.basePath = "https://test.feedbacktuner.com/api";
	}
	
	public String getBaseURI() {
		return RestAssured.baseURI = "/login";	 
	}
	
	public BaseAPI() {
		
	}
	
	public void getCookieAfterLogin() {
		Map<String, String> jsonAsMap = new HashMap<>();
	    jsonAsMap.put("username", "roy.daklon@mailinator.com");
	    jsonAsMap.put("password", "Nji90okm");
	    RestAssured.given().
	        contentType("application/json").
	        body(jsonAsMap).
	        when().
	        post(RestAssured.basePath + RestAssured.baseURI).
	    then().statusCode(200).log().all();
	}

}
