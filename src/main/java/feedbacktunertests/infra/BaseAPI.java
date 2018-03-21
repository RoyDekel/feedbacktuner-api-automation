package feedbacktunertests.infra;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	private static Response response;
	private final String VALID_USER = "roy.daklon@mailinator.com";
	private final String VALID_PASSWORD = "Nji90okm";
	
	public BaseAPI() {
	}
	
	public String getBasePath() {
		return RestAssured.basePath = "https://test.feedbacktuner.com/api";
	}
	
	public String getBaseURI(String URI) {
		return RestAssured.baseURI = URI;	 
	}
	
	public RequestSpecification given() {
		return RestAssured.given();
	}
	
	// Get the Cookie of the user and cut the curly brackets from it
	public String getCookieAfterLogin() {
		Map<String, String> jsonAsMap = new HashMap<>();
	    jsonAsMap.put("username", VALID_USER);
	    jsonAsMap.put("password", VALID_PASSWORD);
	    response = given().
	        contentType("application/json").
	        body(jsonAsMap).
	        when().
	        post(getBasePath() + getBaseURI("/login"));
	    String authCookie = response.getCookies().toString().
	    		replace("{", "").trim().
	    		replace("}", "").trim();
	    return authCookie;
	}
	
	public void logout() {
		RestAssured.given().
		contentType("application/json").
		when().
		post(getBasePath() + getBaseURI("/logout"))
		.then().statusCode(200);
	}
}
