package com.park.pojo;

public class CapacityPOJO {

	private String createdBy= null;
	private Integer groupId= null;
	private String groupName= null;
	private Integer businessId= null;
	private String businessName= null;
	private String serverMacAddress= null;
	private String serverName= null;
	private String companyName= null;
	private Integer capacity2w= null;
	private Integer capacity4w = null;
	public String getCreatedBy() {
		return createdBy;
	}
	public CapacityPOJO setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public CapacityPOJO setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
	public String getGroupName() {
		return groupName;
	}
	public CapacityPOJO setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public CapacityPOJO setBusinessId(Integer businessId) {
		this.businessId = businessId;
		return this;
	}
	public String getBusinessName() {
		return businessName;
	}
	public CapacityPOJO setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	public String getServerMacAddress() {
		return serverMacAddress;
	}
	public CapacityPOJO setServerMacAddress(String serverMacAddress) {
		this.serverMacAddress = serverMacAddress;
		return this;
	}
	public String getServerName() {
		return serverName;
	}
	public CapacityPOJO setServerName(String serverName) {
		this.serverName = serverName;
		return this;
	}
	public String getCompanyName() {
		return companyName;
	}
	public CapacityPOJO setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	public Integer getCapacity2w() {
		return capacity2w;
	}
	public CapacityPOJO setCapacity2w(Integer capacity2w) {
		this.capacity2w = capacity2w;
		return this;
	}
	public Integer getCapacity4w() {
		return capacity4w;
	}
	public CapacityPOJO setCapacity4w(Integer capacity4w) {
		this.capacity4w = capacity4w;
		return this;
	}
	@Override
	public String toString() {
		return "CapacityPOJO [createdBy=" + createdBy + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", businessId=" + businessId + ", businessName=" + businessName + ", serverMacAddress="
				+ serverMacAddress + ", serverName=" + serverName + ", companyName=" + companyName + ", capacity2w="
				+ capacity2w + ", capacity4w=" + capacity4w + "]";
	}
	
}
