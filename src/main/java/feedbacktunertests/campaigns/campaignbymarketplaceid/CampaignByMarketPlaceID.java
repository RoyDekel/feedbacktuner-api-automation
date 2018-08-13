package feedbacktunertests.campaigns.campaignbymarketplaceid;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.BaseRequests;
import feedbacktunertests.marketplaces.MarketPlaces;

public class CampaignByMarketPlaceID {

    private static CampaignByMarketPlaceID instance=null;

    public CampaignByMarketPlaceID() {
    }

    public static CampaignByMarketPlaceID getInstance() {
        if (instance == null) {
            instance = new CampaignByMarketPlaceID();
        }
        return instance;
    }

    public Response getCampaignByMarketPlace() {
        ContentType contentType = ContentType.URLENC;
        return new BaseRequests(contentType)
                .getRequest("/campains?marketPlaceId=" + MarketPlaces.getInstance().getDataFromJson("id")
                        .replace("[", "").trim()
                        .replace("]", "").trim());
    }

    public String getJSONObjectAsString() {
        return getCampaignByMarketPlace().asString();
    }

    public String getTemplate(String parameter) {
        return getCampaignByMarketPlace().jsonPath().getString(parameter);
    }
}
