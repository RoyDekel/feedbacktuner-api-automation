package feedbacktunertests.marketplaces;

import java.sql.SQLException;

import feedbacktunertests.infra.BaseAPI;
import io.restassured.response.Response;

public class MarketPlaces extends BaseAPI {

	
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
		Response response = given().
		        cookie(getCookieAfterLogin()).
		        when().
		        get(getBasePath() + getBaseURI("/marketplaces")).
		        then().statusCode(200).extract().response();
		return response;
	}
	
	public String getDataFromJson(String parameter) {
		return getMarketPlaces().jsonPath().getString(parameter);
	}
	
	public String getJsonObjectAsString() {
		return jsonAsString = getMarketPlaces().getBody().asString();
	}
}
