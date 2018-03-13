package feedbacktunertests.login;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class LoginPage {

	RestAssured ra = new RestAssured();
	
	@BeforeMethod
	public void setBaseURI() {
		RestAssured.basePath = "https://test.feedbacktuner.com/api";
		RestAssured.baseURI = "/login";
	}
	
	@Test
	public void loginToFeedbackTuner() {
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
