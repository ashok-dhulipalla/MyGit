package com.park.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyCapacityPOJO {

	private String createdBy= null;
	private String companyName= null;
	private Integer capacity2w= null;
	private Integer capacity4w = null;
	public String getCreatedBy() {
		return createdBy;
	}
	public CompanyCapacityPOJO setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public String getCompanyName() {
		return companyName;
	}
	public CompanyCapacityPOJO setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	public Integer getCapacity2w() {
		return capacity2w;
	}
	public CompanyCapacityPOJO setCapacity2w(Integer capacity2w) {
		this.capacity2w = capacity2w;
		return this;
	}
	public Integer getCapacity4w() {
		return capacity4w;
	}
	public CompanyCapacityPOJO setCapacity4w(Integer capacity4w) {
		this.capacity4w = capacity4w;
		return this;
	}
	
}
