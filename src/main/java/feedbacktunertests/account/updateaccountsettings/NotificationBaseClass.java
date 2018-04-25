package feedbacktunertests.account.updateaccountsettings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationBaseClass {
	
	protected Boolean enabled;
	protected String email;
	protected String phoneNumber;
	
	public NotificationBaseClass() {
		
	}
	
	/**
	 * @param enabled
	 * @param email
	 * @param phoneNumber
	 */
	@JsonCreator
	public NotificationBaseClass(@JsonProperty("enabled") Boolean enabled,
			@JsonProperty("email") String email, @JsonProperty("phoneNumber")String phoneNumber) {
		this.enabled = enabled;
		this.email = email;
		this.phoneNumber = phoneNumber;	
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
