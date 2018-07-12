package feedbacktunertests.campaigns.campaignbymarketplaceid;

import java.sql.SQLException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import feedbacktunertests.infra.BaseAPI;
import feedbacktunertests.infra.BaseRequests;

public class CampaignByMarketPlaceID extends BaseAPI {

    //MarketPlaces marketPlace = new MarketPlaces();

    public CampaignByMarketPlaceID() {
        try {
            establishConnection();
            selectUsernameFromDB();
        }
        catch (IllegalAccessException | ClassNotFoundException | InstantiationException | SQLException e) {
            throw new AssertionError("Failed to connect to MySql DB", e);
        }
    }

    public Response getCampaignByMarketPlace() {
        ContentType contentType = ContentType.URLENC;
        //String getMarketPlaceId = marketPlace.getDataFromJson("id");
        return response = new BaseRequests(contentType)
                .getRequest("/campains?marketPlaceId=124"); //+ getMarketPlaceId);
    }

    public String getJSONObjectAsString() {
        return getCampaignByMarketPlace().asString();
    }

    public String getTemplate(String parameter) {
        return getCampaignByMarketPlace().jsonPath().getString(parameter);
    }
}
