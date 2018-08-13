package feedbacktunertests.campaigns;

import java.sql.SQLException;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.ConnectionToDB;

public class Campaigns {

	public Campaigns() {
		try {
			ConnectionToDB.getInstance().establishConnection();
			ConnectionToDB.getInstance().selectUsernameFromDB();
		} 
		catch (ClassNotFoundException | SQLException e) {
			throw new AssertionError("Failed to connect to MySql DB", e);
		} 
	}
	
	
}
