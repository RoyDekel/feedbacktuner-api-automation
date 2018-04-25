package feedbacktunertests.account.updateaccountsettings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyInfoObject {

	private String firstName;
	private String lastName;
	private String companyName;
	private String vatNumber;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phoneNumber;
	
	public CompanyInfoObject() {
		
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param companyName
	 * @param vatNumber
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param country
	 * @param zipCode
	 * @param phoneNumber
	 */
	@JsonCreator
	public CompanyInfoObject(@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName,
			@JsonProperty("companyName") String companyName,
			@JsonProperty("vatNumber") String vatNumber,
			@JsonProperty("streetAddress") String streetAddress,
			@JsonProperty("city") String city,
			@JsonProperty("state") String state,
			@JsonProperty("country") String country,
			@JsonProperty("zipCode") String zipCode,
			@JsonProperty("phoneNumber") String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.vatNumber = vatNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
