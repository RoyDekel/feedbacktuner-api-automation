package feedbacktunertests.infra;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	RestAssured ra = new RestAssured();
	public static Response response;
	public final String VALID_USER = "roy.daklon@mailinator.com";
	public final String VALID_PASSWORD = "Nji90okm";
	
	public BaseAPI() {
	}
	
	public String getBasePath() {
		return RestAssured.basePath = "https://test.feedbacktuner.com/api";
	}
	
	public String getBaseURI() {
		return RestAssured.baseURI = "/login";	 
	}
	
	public RequestSpecification httpRequest() {
		return RestAssured.given();
	}
	
	// Get the Cookie of the user and cut the curly brackets from it
	public String getCookieAfterLogin() {
		Map<String, String> jsonAsMap = new HashMap<>();
	    jsonAsMap.put("username", VALID_USER);
	    jsonAsMap.put("password", VALID_PASSWORD);
	    response = RestAssured.given().
	        contentType("application/json").
	        body(jsonAsMap).
	        when().
	        post(getBasePath() + getBaseURI());
	    String authCookie = response.getCookies().toString().
	    		replace("{", "").trim().
	    		replace("}", "").trim();
	    return authCookie;
	}
}
