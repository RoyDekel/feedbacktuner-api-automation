package feedbacktunertests.marketplaces;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMarketPlace {
	
	public MarketPlaces marketPlace = new MarketPlaces();
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "amazonSellerId", enabled = true)
	public void amazonSellerIdTest(String value) {
		String amazonSellerId = marketPlace.getDataFromJson("amazonSellerId");
		marketPlace.logout();
	    Assert.assertEquals(amazonSellerId, value);
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "marketPlaceId", enabled = false)
	public void marketPlaceIdTest(String value) {
		String getMarketPlaceId = marketPlace.getDataFromJson("id");		
		Assert.assertEquals(getMarketPlaceId, value);
	}
}
