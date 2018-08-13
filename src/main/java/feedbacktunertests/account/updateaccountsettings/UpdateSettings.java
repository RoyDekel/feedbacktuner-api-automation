package feedbacktunertests.account.updateaccountsettings;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.BaseRequests;
import feedbacktunertests.infra.ConnectionToDB;


import java.sql.SQLException;

public class UpdateSettings extends BaseAPI {

	public UpdateSettings() {
		try {
			ConnectionToDB.getInstance().establishConnection();
			ConnectionToDB.getInstance().selectUsernameFromDB();
		} 
		catch (ClassNotFoundException | SQLException e) {
			throw new AssertionError("Failed to connect to MySql DB", e);
		} 
	}
	
	/**
	 * @param jsonAsString
	 * @return Response object
	 */
	public Response updateAccountSettings(String jsonAsString) {
		ContentType contentType = ContentType.JSON;
		return new BaseRequests(contentType, jsonAsString).putRequest("/account/settings");
	}
}
