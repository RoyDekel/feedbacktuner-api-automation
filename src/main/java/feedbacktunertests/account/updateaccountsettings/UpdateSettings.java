package feedbacktunertests.account.updateaccountsettings;

import java.sql.SQLException;
import feedbacktunertests.infra.BaseAPI;
import io.restassured.response.Response;

public class UpdateSettings extends BaseAPI {

	public UpdateSettings() {
		try {
			establishConnection();
			selectUsernameFromDB();
		} 
		catch (IllegalAccessException | ClassNotFoundException | InstantiationException | SQLException e) {
			throw new AssertionError("Failed to connect to MySql DB", e);
		} 
	}
	
	public Response updateAccountSettings(String jsonAsString) {
		Response response = given().
				contentType("application/json").
		        body(jsonAsString).
		        cookie(getCookieAfterLogin()).
		        when().
		        put(getBasePath() + getBaseURI("/account/settings")).
		        then().statusCode(200).extract().response();
		return response;
	}
}
