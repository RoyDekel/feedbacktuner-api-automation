package feedbacktunertests.infra;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.testng.annotations.Test;
import java.sql.Connection;

public class TestDBConnection {

	/*
	 * In this program we will see, how can we test the Java connection with the * database
	 */
	 @Test
	 public void estConnection() throws IllegalAccessException, ClassNotFoundException, SQLException, InstantiationException {
	 
	 // Declare the connection as Null
	 Connection conn = null;
	 // This the URL of your local DB
	 String url = "http://feedbacktuner-test.ckunsnoskhjl.us-west-2.rds.amazonaws.com";
	 String driver = "com.mysql.jdbc.Driver";
	 /*
	 * Enter the DB Name (In MySQL enter command 'show databases;') . * Feedback-Test is 
	 * the Test Database in MySQL 
	 * Enter the DB username and password
	 */
	 String dbName = "Feedback-Test";
	 String userName = "fTuner2014";
	 String password = "Seller1985$Kit";
	 
	 //This will create Object of Driver class
	 Class.forName(driver);
	 conn = (Connection) DriverManager.getConnection(url+dbName, userName, password);
	 
	 if (conn != null) {
		 System.out.println("Connection Established, take control your database now!");
	 } 
	 
	 else {
		 System.out.println("Failed to make connection!");
	 }
	 }
}
