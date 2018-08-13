package feedbacktunertests.infra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BaseAPI {

	protected static Response response;
	//protected static String VALID_USER;
	//protected static String VALID_PASSWORD;

	
	public BaseAPI() {
	}
	
	protected String getBaseURI() {
		return RestAssured.baseURI = "https://test.feedbacktuner.com/api";
	}
	
	/**
	 * @param URI
	 * @return String
	 */
	protected String getPath(String URI) {
		return RestAssured.basePath = URI;
	}
	
	protected RequestSpecification given() {
		return RestAssured.given();
	}

	 
	/**
	 * Get the Cookie of the user and cut the curly brackets from it
	 */
	protected String getCookieAfterLogin() {
		Map<String, String> jsonAsMap = new HashMap<>();
	    jsonAsMap.put("username", ConnectionToDB.getInstance().getValidUser());
	    jsonAsMap.put("password", ConnectionToDB.getInstance().getValidPassword());
	    response = given().
	        contentType("application/json").
	        body(jsonAsMap).
	        when().
	        post(getBaseURI() + getPath("/login"));
	    String authCookie = response.getCookies().
	    		toString().
	    		replace("{", "").trim().
	    		replace("}", "").trim();
	    return authCookie;
	}

	// Logout from FeedbackTuner
	public void logout() {
		RestAssured.given().
		contentType("application/json").
		when().
		post(getBaseURI() + getPath("/logout"))
		.then().statusCode(200);
	}
}
