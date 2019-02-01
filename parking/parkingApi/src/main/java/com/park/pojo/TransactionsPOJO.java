package com.park.pojo;

public class TransactionsPOJO {

	private String createdBy= null;
	private Integer transactionId= null;
	private String fullLicencePlate= null;
	private String fourDigitLicencePlate= null;
	private String vehicleType= null;
	private String entryTime= null;
	private String exitTime= null;
	private String recordType= null;
	private String companyName= null;
	private String entryImagePath= null;
	private String exitImagePath= null;
	private Integer parkingDurationInMins= null;
	public String getCreatedBy() {
		return createdBy;
	}
	public TransactionsPOJO setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public String getFullLicencePlate() {
		return fullLicencePlate;
	}
	public TransactionsPOJO setFullLicencePlate(String fullLicencePlate) {
		this.fullLicencePlate = fullLicencePlate;
		return this;
	}
	public String getFourDigitLicencePlate() {
		return fourDigitLicencePlate;
	}
	public TransactionsPOJO setFourDigitLicencePlate(String fourDigitLicencePlate) {
		this.fourDigitLicencePlate = fourDigitLicencePlate;
		return this;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public TransactionsPOJO setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public TransactionsPOJO setEntryTime(String entryTime) {
		this.entryTime = entryTime;
		return this;
	}
	public String getExitTime() {
		return exitTime;
	}
	public TransactionsPOJO setExitTime(String exitTime) {
		this.exitTime = exitTime;
		return this;
	}
	public String getRecordType() {
		return recordType;
	}
	public TransactionsPOJO setRecordType(String recordType) {
		this.recordType = recordType;
		return this;
	}
	public String getEntryImagePath() {
		return entryImagePath;
	}
	public TransactionsPOJO setEntryImagePath(String entryImagePath) {
		this.entryImagePath = entryImagePath;
		return this;
	}
	public String getExitImagePath() {
		return exitImagePath;
	}
	public TransactionsPOJO setExitImagePath(String exitImagePath) {
		this.exitImagePath = exitImagePath;
		return this;
	}
	public String getCompanyName() {
		return companyName;
	}
	public TransactionsPOJO setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	public Integer getParkingDurationInMins() {
		return parkingDurationInMins;
	}
	public TransactionsPOJO setParkingDurationInMins(Integer parkingDurationInMins) {
		this.parkingDurationInMins = parkingDurationInMins;
		return this;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public TransactionsPOJO setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	public String entryValidation()
	{
		String response= "";
		if(fullLicencePlate == null)
			response+= "Mandatory fields fullLicencePlate";
		if(fourDigitLicencePlate == null)
			response+= "fourDigitLicencePlate,";
		if(vehicleType == null)
			response+= "vehicleType,";
		if(recordType == null)
			response+= "recordType,";
		if(companyName == null)
			response+= "companyName,";
		if(entryImagePath == null)
			response+= "entryImagePath";
		return response.isEmpty()?null:response;
	}
	
	public String exitValidation()
	{
		String response= "";
		if(transactionId == null)
			response+= "Mandatory fields transactionId";
		if(fullLicencePlate == null)
			response+= "fullLicencePlate";
		if(exitImagePath == null)
			response+= "exitImagePath";
		return response.isEmpty()?null:response;
	}
	
}
