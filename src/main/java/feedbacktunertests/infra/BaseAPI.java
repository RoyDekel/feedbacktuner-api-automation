package feedbacktunertests.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	protected static Response response;
	protected final static String VALID_USER = "roy.daklon@mailinator.com";
	protected static String VALID_PASSWORD;
	protected static Connection conn = null;
	
	public BaseAPI() {
	}
	
	protected String getBaseURI() {
		return RestAssured.baseURI = "https://test.feedbacktuner.com/api";
	}
	
	protected String getPath(String URI) {
		return RestAssured.basePath = URI;	 
	}
	
	protected RequestSpecification given() {
		return RestAssured.given();
	}
	
	protected void establishConnection() throws IllegalAccessException, ClassNotFoundException, 
	SQLException, InstantiationException {
		 // This the URL of your local DB
		 String url = "jdbc:mysql://feedbacktuner-test.ckunsnoskhjl.us-west-2.rds.amazonaws.com:3306/feedbacktuner?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
		 String driver = "com.mysql.jdbc.Driver";
		 // Enter the DB username and password
		 String userName = "fTuner2014";
		 String password = "Seller1985$Kit";
		 //This will create Object of Driver class
		 Class.forName(driver);
		 conn = (Connection) DriverManager.getConnection(url, userName, password);
		 if (conn != null) {
			 System.out.println("Connection Established, take control your database now!");
		 } 
		 else {
			 System.out.println("Failed to make connection!");
		 }
	}
	
	protected void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get the Cookie of the user and cut the curly brackets from it
	protected String getCookieAfterLogin() {
		Map<String, String> jsonAsMap = new HashMap<>();
	    jsonAsMap.put("username", VALID_USER);
	    jsonAsMap.put("password", VALID_PASSWORD);
	    response = given().
	        contentType("application/json").
	        body(jsonAsMap).
	        when().
	        post(getBaseURI() + getPath("/login"));
	    String authCookie = response.getCookies().
	    		toString().
	    		replace("{", "").trim().
	    		replace("}", "").trim();
	    return authCookie;
	}

	// Logout from FeedbackTuner
	public void logout() {
		RestAssured.given().
		contentType("application/json").
		when().
		post(getBaseURI() + getPath("/logout"))
		.then().statusCode(200);
	}
	
	protected void selectUsernameFromDB() {
		// Create a statement to be executed
		String dbQuery = "SELECT * FROM feedbacktuner.user where email = '" + VALID_USER + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(dbQuery);
			while (rs.next())
				VALID_PASSWORD = rs.getString("password");
		} 
        catch (SQLException e) {
			e.printStackTrace();
        }
	}
}
