package feedbacktunertests.marketplaces;

import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.ConnectionToDB;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TestMarketPlace {
	
	private BaseAPI baseAPI = new BaseAPI();
	
	@BeforeClass
	public void setup() {
		try {
			ConnectionToDB.getInstance().establishConnection();
			ConnectionToDB.getInstance().selectUsernameFromDB();
		}
		catch (ClassNotFoundException | SQLException e) {
			throw new AssertionError("Failed to connect to MySql DB", e);
		}
	}

	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "amazonSellerId")
	public void amazonSellerIdTest(String value) {
		String amazonSellerId = MarketPlaces.getInstance().getDataFromJson("amazonSellerId");
		baseAPI.logout();
	    Assert.assertEquals(amazonSellerId, value);
	}
	
	@Test(dataProviderClass = DataProviderMarketPlaces.class, dataProvider = "marketPlaceId")
	public void marketPlaceIdTest(String value) {
		String getMarketPlaceId = MarketPlaces.getInstance().getDataFromJson("id");
		baseAPI.logout();
		Assert.assertEquals(getMarketPlaceId, value);
	}

	@AfterClass
	public void tearDown() {
		ConnectionToDB.getInstance().closeConnection();
	}
}
