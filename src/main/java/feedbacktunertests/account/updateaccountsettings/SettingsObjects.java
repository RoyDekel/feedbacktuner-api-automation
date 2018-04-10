package feedbacktunertests.account.updateaccountsettings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingsObjects {
	
	public String defaultTestEmailAddress;
	public String timeZone;
	public Integer defaultMarketPlaceId;
	public Boolean autoBlacklistOnNegativeFeedback;
	public NotificationBaseClass negativeFeedbackNotification;
	public NotificationBaseClass negativeReviewsNotifications;
	public WeeklyAccountSummary weeklyAccountSummary;
	public CompanyInfoObject companyInfo;
	
	public SettingsObjects() {
		
	}
	
	@JsonCreator
	public SettingsObjects(@JsonProperty("defaultTestEmailAddress") String defaultTestEmailAddress, 
			@JsonProperty("timeZone") String timeZone,
			@JsonProperty("defaultMarketPlaceId") int defaultMarketPlaceId,
			@JsonProperty("autoBlacklistOnNegativeFeedback") Boolean autoBlacklistOnNegativeFeedback,
			@JsonProperty("negativeFeedbackNotification") NotificationBaseClass negativeFeedbackNotification,
			@JsonProperty("negativeReviewsNotifications") NotificationBaseClass negativeReviewsNotifications,
			@JsonProperty("weeklyAccountSummary")WeeklyAccountSummary weeklyAccountSummary,
			@JsonProperty("companyInfo") CompanyInfoObject companyInfo) {
		this();
		this.defaultTestEmailAddress = defaultTestEmailAddress;
		this.timeZone = timeZone;
		this.defaultMarketPlaceId = defaultMarketPlaceId;
		this.autoBlacklistOnNegativeFeedback = autoBlacklistOnNegativeFeedback;
		this.negativeFeedbackNotification = negativeFeedbackNotification;
		this.negativeReviewsNotifications = negativeReviewsNotifications;
		this.weeklyAccountSummary = weeklyAccountSummary;
		this.companyInfo = companyInfo;
	}
	
	public void setDefaultTestEmailAddress(String email) {
		defaultTestEmailAddress = email;
	}
	
	public void setTimeZone(String newTimeZone) {
		timeZone = newTimeZone;
	}
	
	public void setDefaultMarketPlaceId(int marketPlaceId) {
		defaultMarketPlaceId = marketPlaceId;
	}
	
	public void isAutoBlacklistOnNegativeFeedback(Boolean newAutoBlacklistOnNegativeFeedback) {
		autoBlacklistOnNegativeFeedback = newAutoBlacklistOnNegativeFeedback;
	}

	public void setNegativeFeedbackNotification(boolean enabled, String email, String phoneNumber) {
		negativeFeedbackNotification = new NotificationBaseClass(enabled, email, phoneNumber);
	}

	public void setNegativeReviewNotification(boolean enabled, String email, String phoneNumber) {
		negativeReviewsNotifications = new NotificationBaseClass(enabled, email, phoneNumber);
	}

	public void setWeeklyAccountSummary(String email, String sendEmailOn) {
		weeklyAccountSummary = new WeeklyAccountSummary(email, sendEmailOn);	
	}

	public void setCompanyInfo(String firstName, String lastName, String companyName, String vatNumber,
			String streetAddress, String city, String state, String country, String zipCode, String phoneNumber) {
		companyInfo = new CompanyInfoObject(firstName, lastName, companyName, vatNumber, streetAddress, city, state, country, zipCode, phoneNumber);
	}
}
