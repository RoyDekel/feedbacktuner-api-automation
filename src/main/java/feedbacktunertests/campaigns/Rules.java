package feedbacktunertests.campaigns;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rules {

    public String ruleType;
    public int xDays;
    public int afterXDays;
    public String criteriaDate;
    public List<String> conditions;
    public String feedbackType;
    public String comparatorType;
    public List<String> countries;
    public String channel;

    public Rules() {

    }

    @JsonCreator
    public Rules(@JsonProperty("ruleType") String ruleType,
                 @JsonProperty("xDays") int xDays,
                 @JsonProperty("afterXDays") int afterXDays,
                 @JsonProperty("criteriaDate") String criteriaDate,
                 @JsonProperty("conditions") List<String> conditions,
                 @JsonProperty("feedbackType") String feedbackType,
                 @JsonProperty("comparatorType") String comparatorType,
                 @JsonProperty("countries") List<String> countries,
                 @JsonProperty("channel") String channel) {
        this.ruleType = ruleType;
        this.xDays = xDays;
        this.afterXDays = afterXDays;
        this.criteriaDate = criteriaDate;
        this.conditions = conditions;
        this.feedbackType = feedbackType;
        this.comparatorType = comparatorType;
        this.countries = countries;
        this.channel = channel;
    }
}
