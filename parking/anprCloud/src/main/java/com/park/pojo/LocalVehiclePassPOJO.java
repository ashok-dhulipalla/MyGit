package com.park.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalVehiclePassPOJO {

	private String createdBy= null;
	private String fullLicencePlate= null;
	private String fourDigitLicencePlate= null;
	private Integer passId= null;
	private String expiryDate= null;
	private String updationDate= null;
	private String vehicleType= null;
	private String companyName= null;
	public String getCreatedBy() {
		return createdBy;
	}
	public LocalVehiclePassPOJO setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public String getCompanyName() {
		return companyName;
	}
	public LocalVehiclePassPOJO setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	public String getFullLicencePlate() {
		return fullLicencePlate;
	}
	public LocalVehiclePassPOJO setFullLicencePlate(String fullLicencePlate) {
		this.fullLicencePlate = fullLicencePlate;
		return this;
	}
	public String getFourDigitLicencePlate() {
		return fourDigitLicencePlate;
	}
	public LocalVehiclePassPOJO setFourDigitLicencePlate(String fourDigitLicencePlate) {
		this.fourDigitLicencePlate = fourDigitLicencePlate;
		return this;
	}
	public Integer getPassId() {
		return passId;
	}
	public LocalVehiclePassPOJO setPassId(Integer passId) {
		this.passId = passId;
		return this;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public LocalVehiclePassPOJO setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
		return this;
	}
	public String getUpdationDate() {
		return updationDate;
	}
	public LocalVehiclePassPOJO setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
		return this;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public LocalVehiclePassPOJO setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	
}
