package feedbacktunertests.marketplaces;

import org.testng.annotations.DataProvider;

public class DataProviderMarketPlaces {

	@DataProvider(name = "amazonSellerId")
	public static Object[][] amazonSellerId() {
		return new Object[][] {
			new Object[] { "[A14PABE1P9H9M8]" } 
		};
	}
	
	@DataProvider(name = "marketPlaceId")
	public static Object[][] marketPlaceId() {
		return new Object[][] {{ "[124]" }} ;
	}
}

