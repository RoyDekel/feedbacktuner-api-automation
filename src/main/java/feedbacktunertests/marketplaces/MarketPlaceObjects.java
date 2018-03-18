package feedbacktunertests.marketplaces;

import feedbacktunertests.infra.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MarketPlaceObjects {

	BaseAPI baseAPI = new BaseAPI();
	RestAssured ra;
	
	public MarketPlaceObjects() {
		baseAPI.getCookieAfterLogin();
	}
	
	public Response httpRequestGet() {
		Response response = baseAPI.httpRequest().
		        cookie(baseAPI.getCookieAfterLogin()).
		        when().
		        get(baseAPI.getBasePath() + baseAPI.getBaseURI("/marketplaces")).
		        then().statusCode(200).extract().response();
		return response;
	}
	
	public String fetchStringFromResponse(String parameter) {
		return httpRequestGet().jsonPath().getString(parameter);
	}
}
