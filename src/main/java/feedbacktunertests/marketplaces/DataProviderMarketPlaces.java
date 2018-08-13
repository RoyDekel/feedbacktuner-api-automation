package feedbacktunertests.marketplaces;

import org.testng.annotations.DataProvider;

public class DataProviderMarketPlaces {

	@DataProvider(name = "amazonSellerId")
	public static Object[][] amazonSellerId() {
		return new Object[][] {
			new Object[] { "[A2SGN4CVJWVM94]" }
		};
	}
	
	@DataProvider(name = "marketPlaceId")
	public static Object[][] marketPlaceId() {
		return new Object[][] {{ "[65]" }
		};
	}
}

