package feedbacktunertests.marketplaces;

import java.sql.SQLException;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.BaseRequests;
import io.restassured.response.Response;

public class MarketPlaces extends BaseAPI {

	public BaseRequests baseReq; 
	public static String jsonAsString;
	
	public MarketPlaces() {
		try {
			establishConnection();
			selectUsernameFromDB();
		} 
		catch (IllegalAccessException | ClassNotFoundException | InstantiationException | SQLException e) {
			throw new AssertionError("Failed to connect to MySql DB", e);
		} 
	}
	
	public Response getMarketPlaces() { 
		return response = new BaseRequests().getRequest("/marketplaces");

	}
	
	public String getDataFromJson(String parameter) {
		return getMarketPlaces().jsonPath().getString(parameter);
	}
	
	public String getJsonObjectAsString() {
		return jsonAsString = getMarketPlaces().getBody().asString();
	}
}
