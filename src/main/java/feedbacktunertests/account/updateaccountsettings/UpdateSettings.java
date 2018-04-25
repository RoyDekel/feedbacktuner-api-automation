package feedbacktunertests.account.updateaccountsettings;

import java.sql.SQLException;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.BaseRequests;
import io.restassured.http.ContentType;
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
	
	/**
	 * @param jsonAsString
	 * @return Response object
	 */
	public Response updateAccountSettings(String jsonAsString) {
		ContentType contentType = ContentType.JSON;
		return response = new BaseRequests(contentType, jsonAsString).putRequest("/account/settings");
	}
}
