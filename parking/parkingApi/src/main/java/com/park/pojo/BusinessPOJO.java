package com.park.pojo;

import java.sql.Time;

public class BusinessPOJO {

	private String createdBy= null;
	private Integer groupId= null;
	private String groupName= null;
	private Integer businessId= null;
	private String businessName= null;
	private String address= null;
	private Time startTime= null;
	private Time endTime= null;
	private String location= null;
	private String contactPersonName= null;
	private String contactNo= null;
	private String techSupportContactNo= null;
	public String getCreatedBy() {
		return createdBy;
	}
	public BusinessPOJO setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public BusinessPOJO setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
	public String getGroupName() {
		return groupName;
	}
	public BusinessPOJO setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public BusinessPOJO setBusinessId(Integer businessId) {
		this.businessId = businessId;
		return this;
	}
	public String getBusinessName() {
		return businessName;
	}
	public BusinessPOJO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public BusinessPOJO setAddress(String address) {
		this.address = address;
		return this;
	}
	public Time getStartTime() {
		return startTime;
	}
	public BusinessPOJO setStartTime(Time startTime) {
		this.startTime = startTime;
		return this;
	}
	public Time getEndTime() {
		return endTime;
	}
	public BusinessPOJO setEndTime(Time endTime) {
		this.endTime = endTime;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public BusinessPOJO setLocation(String location) {
		this.location = location;
		return this;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public BusinessPOJO setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
		return this;
	}
	public String getContactNo() {
		return contactNo;
	}
	public BusinessPOJO setContactNo(String contactNo) {
		this.contactNo = contactNo;
		return this;
	}
	public String getTechSupportContactNo() {
		return techSupportContactNo;
	}
	public BusinessPOJO setTechSupportContactNo(String techSupportContactNo) {
		this.techSupportContactNo = techSupportContactNo;
		return this;
	}
	@Override
	public String toString() {
		return "BusinessPOJO [createdBy=" + createdBy + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", businessId=" + businessId + ", businessName=" + businessName + ", address=" + address
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", location=" + location
				+ ", contactPersonName=" + contactPersonName + ", contactNo=" + contactNo + ", techSupportContactNo="
				+ techSupportContactNo + "]";
	}
	
}
