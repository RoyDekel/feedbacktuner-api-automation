package feedbacktunertests.marketplaces;

import org.testng.Assert;
import org.testng.annotations.Test;

import feedbacktunertests.infra.BaseAPI;

public class TestMarketPlace {
	
	private MarketPlaces marketPlace = new MarketPlaces();
	private BaseAPI baseAPI = new BaseAPI();
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "amazonSellerId", enabled = true)
	public void amazonSellerIdTest(String value) {
		String amazonSellerId = marketPlace.getDataFromJson("amazonSellerId");
		baseAPI.logout();
	    Assert.assertEquals(amazonSellerId, value);
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "marketPlaceId", enabled = true)
	public void marketPlaceIdTest(String value) {
		String getMarketPlaceId = marketPlace.getDataFromJson("id");
		baseAPI.logout();
		Assert.assertEquals(getMarketPlaceId, value);
	}
}
