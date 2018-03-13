package feedbacktunertests.marketplaces;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import feedbacktunertests.infra.BaseAPI;
import io.restassured.response.Response;

public class GetMarketPlace {
	
	BaseAPI baseAPI = new BaseAPI();
	
	@BeforeMethod
	public void setup() {
		baseAPI.getCookieAfterLogin();
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "amazonSellerId")
	public void getAmazonSellerID(String value) {
		Response response = baseAPI.httpRequest().
	        cookie(baseAPI.getCookieAfterLogin()).
	        when().
	        get(baseAPI.getBasePath() + "/marketplaces").
	    then().statusCode(200).extract().response();
		String amazonSellerId = response.jsonPath().getString("amazonSellerId");
	    Assert.assertEquals(amazonSellerId, value);
	}
	
	
}
