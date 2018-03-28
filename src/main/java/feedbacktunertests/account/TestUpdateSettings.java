package feedbacktunertests.account;

import org.testng.annotations.Test;

public class TestUpdateSettings extends UpdateSettings {

	@Test
	public void updateDefaultSettingsTest() {
		updateDefaultMarketPlaceId(124).
		updateDefaultemail("roy.daklon@mailinator.com").
		updateAccountSettings();
	}
	
	@Test
	public void updateCompanyInfoTest() {
		updateCompanyInfo("Roy111", "Dekel", "SolarEdge", "2001", "Hamada 1", "Herzliya", "IL", "Israel", "1544564", null)
		.updateAccountSettings();
	}
}
