package feedbacktunertests.campaigns;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailStats {

    public int sent;
    public int opened;
    public String pending;


    public EmailStats() {

    }

    @JsonCreator
    public EmailStats(@JsonProperty("sent") int sent,
                      @JsonProperty("opened") int opened,
                      @JsonProperty("pending") String pending) {
        this.sent = sent;
        this.opened = opened;
        this.pending = pending;
    }
}
