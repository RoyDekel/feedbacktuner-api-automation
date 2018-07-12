package feedbacktunertests.campaigns;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Template {

    public String templateName;
    public String templateBody;
    public String templateIdentifier;
    public List<Object> templateAttachments;

    public Template() {

    }

    @JsonCreator
    public Template(@JsonProperty("templateName") String templateName,
                    @JsonProperty("templateBody") String templateBody,
                    @JsonProperty("templateIdentifier") String templateIdentifier,
                    @JsonProperty("templateAttachments") List<Object> templateAttachments) {
        this.templateName = templateName;
        this.templateBody = templateBody;
        this.templateIdentifier = templateIdentifier;
        this.templateAttachments = templateAttachments;
    }

    public String getName() {
        return templateName;
    }

    public void setName(String name) {
        this.templateName = name;
    }

    public String getBody() {
        return templateBody;
    }

    public void setBody(String body) {
        this.templateBody = body;
    }

    public String getIdentifier() {
        return templateIdentifier;
    }

    public void setIdentifier(String identifier) {
        this.templateIdentifier = identifier;
    }

    public List<Object> getAttachments() {
        return templateAttachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.templateAttachments = attachments;
    }
}
