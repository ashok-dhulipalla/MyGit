package nice.school.model.tables;

import java.util.Date;

import nice.school.util.Constants;
public class DefaultCols {

	protected Date createdOn= new Date();
	protected String createdBy= Constants.USER_SYSTEM;
	protected Date lastModifiedOn= new Date();
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}
	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	
}
