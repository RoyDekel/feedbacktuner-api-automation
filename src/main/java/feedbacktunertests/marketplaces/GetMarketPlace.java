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
	        cookie("AUTHENTICATION=Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb3kuZGFrbG9uQG1haWxpbmF0b3IuY29tIiwiZXhwIjoxNTIxMjEwOTQ3fQ.-lxEpVNN3gPxP4MSrg5zxBel_jUiHcsHHoDsq1IpK7kwCxF5HNU8PrWmgDR9whEx0r7GjCfi73kB71NOXRvaMA").
	        when().
	        get(baseAPI.getBasePath() + "/marketplaces").
	    then().statusCode(200).log().all();
	}
}
