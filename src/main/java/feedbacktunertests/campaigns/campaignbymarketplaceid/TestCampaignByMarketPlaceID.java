package feedbacktunertests.campaigns.campaignbymarketplaceid;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import feedbacktunertests.infra.ConnectionToDB;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import feedbacktunertests.campaigns.DefaultCampaignObjects;

public class TestCampaignByMarketPlaceID {

    @BeforeClass
    public void setup() {
        try {
            ConnectionToDB.getInstance().establishConnection();
            ConnectionToDB.getInstance().selectUsernameFromDB();
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new AssertionError("Failed to connect to MySql DB", e);
        }
    }

    @Test
    public void numberOfCampaignsTest() {
        List<DefaultCampaignObjects> defaultCampaignObjects;
        defaultCampaignObjects = Arrays.asList(CampaignByMarketPlaceID.getInstance().getCampaignByMarketPlace()
                .getBody().as(DefaultCampaignObjects[].class));
        assertEquals(defaultCampaignObjects.size(), 1);
    }

    @AfterClass
    public void tearDown() {
        ConnectionToDB.getInstance().closeConnection();
    }
}
