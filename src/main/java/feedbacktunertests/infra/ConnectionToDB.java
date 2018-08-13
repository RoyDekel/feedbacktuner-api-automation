package feedbacktunertests.infra;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ConnectionToDB {

    public static Connection conn = null;
    public static String VALID_USER;
    public static String VALID_PASSWORD;
    private static ConnectionToDB instance = null;

    public ConnectionToDB() {
    }

    public static ConnectionToDB getInstance() {
        if (instance == null) {
            instance = new ConnectionToDB();
        }
        return instance;
    }

    public String getValidUser() {
        return VALID_USER;
    }

    public String getValidPassword() {
        return VALID_PASSWORD;
    }

    public void establishConnection() throws ClassNotFoundException, SQLException {
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
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            if (conn != null) {
                System.out.println("Connection Established, take control your database now!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectUsernameFromDB() {
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
