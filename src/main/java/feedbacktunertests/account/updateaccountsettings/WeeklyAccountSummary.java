package feedbacktunertests.account.updateaccountsettings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeeklyAccountSummary {
	
	private String email;
	private String sendEmailOn;
	
	public WeeklyAccountSummary() {
		
	}
	
	@JsonCreator
	public WeeklyAccountSummary(@JsonProperty("email") String email, @JsonProperty("sendEmailOn") String sendEmailOn) {
		this.email = email;
		this.sendEmailOn = sendEmailOn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSendEmailOn() {
		return sendEmailOn;
	}

	public void setSendEmailOn(String sendEmailOn) {
		this.sendEmailOn = sendEmailOn;
	}
}
