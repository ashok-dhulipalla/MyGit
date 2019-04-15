package com.park.pojo;

public class BusinessGroupPOJO {

	String createdBy;
	Integer groupId;
	String groupName;
	String officeAddress;
	String contactPersonName;
	String contactNo;
	public String getCreatedBy() {
		return createdBy;
	}
	public BusinessGroupPOJO setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public BusinessGroupPOJO setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
	public String getGroupName() {
		return groupName;
	}
	public BusinessGroupPOJO setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public BusinessGroupPOJO setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
		return this;
	}
	public String getContactNo() {
		return contactNo;
	}
	public BusinessGroupPOJO setContactNo(String contactNo) {
		this.contactNo = contactNo;
		return this;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public BusinessGroupPOJO setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
		return this;
	}
	@Override
	public String toString() {
		return "BusinessGroupPOJO [createdBy=" + createdBy + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", officeAddress=" + officeAddress + ", contactPersonName=" + contactPersonName + ", contactNo="
				+ contactNo + "]";
	}

	
}
