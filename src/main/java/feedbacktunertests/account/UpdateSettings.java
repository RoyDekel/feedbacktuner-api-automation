package feedbacktunertests.account;

import java.util.HashMap;
import java.util.Map;

import feedbacktunertests.infra.BaseAPI;
import io.restassured.response.Response;

public class UpdateSettings extends BaseAPI {

	private Map<String, Object> jsonAsMap = new HashMap<>();
	
	public UpdateSettings() {
		getCookieAfterLogin();
	}
	
	public UpdateSettings updateCompanyInfo(String firstName, String lastName, String companyName, String vatNumber, 
			String streetAddress, String city, String state, String country, String zipcode, String phoneNumber) {
		jsonAsMap.put("firstName", firstName);
		jsonAsMap.put("lastName", lastName);
		jsonAsMap.put("companyName", companyName);
		jsonAsMap.put("vatNumber", vatNumber);
		jsonAsMap.put("streetAddress", streetAddress);
		jsonAsMap.put("city", city);
		jsonAsMap.put("state", state);
		jsonAsMap.put("country", country);
		jsonAsMap.put("zipcode", zipcode);
		jsonAsMap.put("phoneNumber", phoneNumber);
		return this;
	}
	
	public UpdateSettings updateDefaultMarketPlaceId(int id) {
	    jsonAsMap.put("defaultMarketPlaceId", id);
	    return this;
	}
	
	public Response updateAccountSettings() {
		Response response = given().
				contentType("application/json").
		        body(jsonAsMap).
		        cookie(getCookieAfterLogin()).
		        when().
		        put(getBasePath() + getBaseURI("/account/settings")).
		        then().statusCode(200).extract().response();
		return response;
	}
}
