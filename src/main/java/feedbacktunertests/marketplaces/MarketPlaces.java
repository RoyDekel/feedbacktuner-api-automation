package feedbacktunertests.marketplaces;

import com.jayway.restassured.response.Response;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.BaseRequests;

public class MarketPlaces extends BaseAPI {

	public static String jsonAsString;
	private static MarketPlaces instance = null;

	private MarketPlaces() {

	}

	public static MarketPlaces getInstance() {
		if (instance == null) {
			instance = new MarketPlaces();
		}
		return instance;
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
