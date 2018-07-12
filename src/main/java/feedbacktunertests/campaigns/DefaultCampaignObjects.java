package feedbacktunertests.campaigns;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultCampaignObjects {

    public int userId;
    public int marketPlaceId;
    public String campaignName;
    public String description;
    public String status;
    public String emailSubject;
    public Template template;
    @JsonIgnore
    public Rules rules;
    public EmailStats emailStats;

    public DefaultCampaignObjects() {

    }

    /**
     * @param id
     * @param marketPlaceId
     * @param name
     * @param description
     * @param status
     * @param emailSubject
     * @param template
     * @param emailStats
     */
    @JsonCreator
    public DefaultCampaignObjects(@JsonProperty("id") int userId,
                                  @JsonProperty("marketPlaceId") int marketPlaceId,
                                  @JsonProperty("name") String campaignName,
                                  @JsonProperty("description") String description,
                                  @JsonProperty("status") String status,
                                  @JsonProperty("emailSubject") String emailSubject,
                                  @JsonProperty("template") Template template,
                                  @JsonProperty("emailStats") EmailStats emailStats) {
        this();
        this.userId = userId;
        this.marketPlaceId = marketPlaceId;
        this.campaignName = campaignName;
        this.description = description;
        this.status = status;
        this.emailSubject = emailSubject;
        this.template = template;
        this.emailStats = emailStats;
    }
}
