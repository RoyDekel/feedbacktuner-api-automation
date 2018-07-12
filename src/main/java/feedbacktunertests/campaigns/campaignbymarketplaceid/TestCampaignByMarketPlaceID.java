package feedbacktunertests.campaigns.campaignbymarketplaceid;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import feedbacktunertests.campaigns.DefaultCampaignObjects;

public class TestCampaignByMarketPlaceID {

    private List<DefaultCampaignObjects> defaultCampaignObjects = new ArrayList<>();
    private CampaignByMarketPlaceID campaignByMarketPlaceID = new CampaignByMarketPlaceID();

    @Test
    public void numberOfCampaignsTest() {
        defaultCampaignObjects = Arrays.asList(campaignByMarketPlaceID.getCampaignByMarketPlace()
                .getBody().as(DefaultCampaignObjects[].class));
        assertEquals(defaultCampaignObjects.size(), 3);
    }
}
