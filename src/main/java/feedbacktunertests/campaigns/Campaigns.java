package feedbacktunertests.campaigns;

import java.sql.SQLException;
import feedbacktunertests.infra.BaseAPI;

public class Campaigns extends BaseAPI {

	public Campaigns() {
		try {
			establishConnection();
			selectUsernameFromDB();
		} 
		catch (IllegalAccessException | ClassNotFoundException | InstantiationException | SQLException e) {
			throw new AssertionError("Failed to connect to MySql DB", e);
		} 
	}
	
	
}
