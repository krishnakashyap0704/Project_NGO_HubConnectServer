package com.DonationBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Ngo")
public class Ngo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NGO_id")
	private Integer ngoId;

	@Column(name = "Organization_Name")
	private String organizationName;

	@Column(name = "Darpan_ID")
	private String darpanId;

	@Column(name = "Email")
	private String email;

	@Column(name = "Vision")
	private String vision;

	@Column(name = "Phone", nullable = false, length = 12)
	private String phone;

	@Column(name = "Address")
	private String address;

	@Column(name = "Website")
	private String website;

	@Column(name = "YearOfEstablishment")
	private Integer yearsOfEstablishment;

	@Column(name = "KeyFocusAreas")
	private String keyFocuseAreas;
	
	@Column(name = "IsApproved")
    private boolean isApproved;

	public Integer getNgoId() {
		return ngoId;
	}

	public void setNgoId(Integer ngoId) {
		this.ngoId = ngoId;
	}

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
	
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
}
