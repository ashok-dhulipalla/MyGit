package nice.school.model.tables;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

public class Config extends DefaultCols{

	private String configKey;
	private String configValue;
	private String dataType;

	
	public String getConfigKey() {
		return configKey;
	}
	public Config setConfigKey(String configKey) {
		this.configKey = configKey;
		return this;
	}
	public String getConfigValue() {
		return configValue;
	}
	public Config setConfigValue(String configValue) {
		this.configValue = configValue;
		return this;
	}
	public String getDataType() {
		return dataType;
	}
	public Config setDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Config [createdOn=");
		builder.append(createdOn);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", lastModifiedOn=");
		builder.append(lastModifiedOn);
		builder.append(", configKey=");
		builder.append(configKey);
		builder.append(", configValue=");
		builder.append(configValue);
		builder.append(", dataType=");
		builder.append(dataType);
		builder.append("]");
		return builder.toString();
	}

}
