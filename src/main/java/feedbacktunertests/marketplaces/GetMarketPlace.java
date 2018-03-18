package feedbacktunertests.marketplaces;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import feedbacktunertests.infra.BaseAPI;

public class GetMarketPlace {
	
	BaseAPI baseAPI = new BaseAPI();
	MarketPlaceObjects marketPlaceObject = new MarketPlaceObjects();
	
	@BeforeMethod
	public void setup() {
		baseAPI.getCookieAfterLogin();
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "amazonSellerId", enabled = true)
	public void amazonSellerIdTest(String value) {
		String amazonSellerId = marketPlaceObject.fetchStringFromResponse("amazonSellerId");
	    Assert.assertEquals(amazonSellerId, value);
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "marketPlaceId", enabled = true)
	public void marketPlaceIdTest(String value) {
		String getMarketPlaceId = marketPlaceObject.fetchStringFromResponse("id");		
		Assert.assertEquals(getMarketPlaceId, value);
	}
}
