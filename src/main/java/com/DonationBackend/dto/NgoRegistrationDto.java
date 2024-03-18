package com.DonationBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NgoRegistrationDto {
	@JsonProperty(value = "Organization_Name")
	private String organizationName;
	@JsonProperty(value = "Darpan_ID")
	private String darpanId;
	@JsonProperty(value = "Email")
	private String email;
	@JsonProperty(value = "Vision")
	private String vision;
	@JsonProperty(value = "Phone")
	private String phone;
	@JsonProperty(value = "Address")
	private String address;
	@JsonProperty(value = "Website")
	private String website;
	@JsonProperty(value = "YearOfEstablishment")
	private Integer yearsOfEstablishment;
	@JsonProperty(value = "KeyFocusAreas")
	private String keyFocuseAreas;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDarpanId() {
		return darpanId;
	}

	public void setDarpanId(String darpanId) {
		this.darpanId = darpanId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getYearsOfEstablishment() {
		return yearsOfEstablishment;
	}

	public void setYearsOfEstablishment(Integer yearsOfEstablishment) {
		this.yearsOfEstablishment = yearsOfEstablishment;
	}

	public String getKeyFocuseAreas() {
		return keyFocuseAreas;
	}

	public void setKeyFocuseAreas(String keyFocuseAreas) {
		this.keyFocuseAreas = keyFocuseAreas;
	}
	
}

