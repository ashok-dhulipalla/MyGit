package com.ash.xmlPojoConverter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Company {
	
	private String id;
	private String name;
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlValue
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
