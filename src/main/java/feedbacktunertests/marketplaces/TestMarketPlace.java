package feedbacktunertests.marketplaces;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMarketPlace extends MarketPlaces {
	
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "amazonSellerId", enabled = true)
	public void amazonSellerIdTest(String value) {
		String amazonSellerId = getDataFromJson("amazonSellerId");
		logout();
	    Assert.assertEquals(amazonSellerId, value);
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "marketPlaceId", enabled = false)
	public void marketPlaceIdTest(String value) {
		String getMarketPlaceId = getDataFromJson("id");		
		Assert.assertEquals(getMarketPlaceId, value);
	}
}
