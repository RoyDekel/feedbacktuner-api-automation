package feedbacktunertests.account.updateaccountsettings;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUpdateSettings {

	private UpdateSettings updateSettings = new UpdateSettings();
	private SettingsObjects settingsObjects = new SettingsObjects();
	private ObjectMapper objectMapper = new ObjectMapper();
	private String jsonAsString;
	
	@Test
	public void updateDefaultSettingsTest() throws JsonProcessingException {
		// Negative Feedback Object
		settingsObjects.setNegativeFeedbackNotification(false, "ttt@grti.com", "0546235552");
		// Negative Review Object
		settingsObjects.setNegativeReviewNotification(false, "rrr@ggg.com", "0526665551");
		// Weekly Account Summary Object
		settingsObjects.setWeeklyAccountSummary("rrr@g.com", "Monday");
		// Company info Object
		settingsObjects.setCompanyInfo("John",
										"Mcmahon",
										"FeedbackTuner", 
										"101",
										"Maskit 2",
										"Tel Aviv",
										null,
										"Israel",
										"568476e",
										"0525678654");
		// Update the default parameters of the JSON and sending the objects
		settingsObjects = new SettingsObjects("roy.daklon@mailinator.comm",
				"America/Chicago", 
				166, 
				true,
				settingsObjects.negativeFeedbackNotification,
				settingsObjects.negativeReviewsNotifications,
				settingsObjects.weeklyAccountSummary,
				settingsObjects.companyInfo);
		jsonAsString = objectMapper.writeValueAsString(settingsObjects);
		updateSettings.updateAccountSettings(jsonAsString);
	}
}
