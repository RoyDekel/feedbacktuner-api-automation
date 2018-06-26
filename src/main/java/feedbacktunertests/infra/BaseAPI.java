package feedbacktunertests.infra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BaseAPI {

	protected static Response response;
	protected static String VALID_USER;
	protected static String VALID_PASSWORD;
	protected static Connection conn = null;
	
	public BaseAPI() {
	}
	
	protected String getBaseURI() {
		return RestAssured.baseURI = "https://test.feedbacktuner.com/api";
	}
	
	/**
	 * @param URI
	 * @return String
	 */
	protected String getPath(String URI) {
		return RestAssured.basePath = URI;	 
	}
	
	protected RequestSpecification given() {
		return RestAssured.given();
	}
	
	protected void establishConnection() throws IllegalAccessException, ClassNotFoundException, 
	SQLException, InstantiationException {
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\royda\\Documents\\details.json"));
			JSONObject jsonObject = (JSONObject) obj;
			String dbURL = (String) jsonObject.get("dbURL");
			String driver = (String) jsonObject.get("driver");
			String dbUsername = (String) jsonObject.get("dbUsername");
			String dbPassword = (String) jsonObject.get("dbPassword");
			VALID_USER = (String) jsonObject.get("username");
			//This will create Object of Driver class
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			if (conn != null) {
				System.out.println("Connection Established, take control your database now!");
			} 
			else {
				System.out.println("Failed to make connection!");
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	protected void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	/**
	 * Get the Cookie of the user and cut the curly brackets from it
	 */
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
