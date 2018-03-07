package feedbacktunertests.marketplaces;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import feedbacktunertests.infra.BaseAPI;
import io.restassured.RestAssured;

public class GetMarketPlace {
	
	BaseAPI baseAPI = new BaseAPI();
	
	@BeforeMethod
	public void setup() {
		baseAPI.getCookieAfterLogin();
	}
	
	@Test
	public void getAmazonSellerID() {
	    RestAssured.given().
	        cookie(baseAPI.getCookieAfterLogin()).
	        when().
	        get(baseAPI.getBasePath() + "/marketplaces").
	    then().statusCode(200).log().all();
	}
}
