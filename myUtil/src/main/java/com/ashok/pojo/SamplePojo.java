package com.ashok.pojo;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ashok.util.MyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@XmlRootElement(name="rootElement")
@XmlAccessorType(XmlAccessType.FIELD)
/*NONE	Only annotated fields and properites should be serialized>
FIELD	All fields (public or private) should be serialized>
PROPERTY	All properties (public or private) should be serialized>
PUBLIC_MEMBER	Public fields and properties>*/
public class SamplePojo {

	String firstName;
	String middleName;
	String lastName;
	String gender;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("XmlPojo [firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}
	public static void main(String[] args) throws JAXBException, IOException {
		
		Object obj= new SamplePojo();
		System.out.println(obj.getClass());
		
		SamplePojo pojo= new SamplePojo();
		pojo.setFirstName("Ashok");
		pojo.setMiddleName("Kumar");
		pojo.setLastName("Dhulipalla");
		pojo.setGender("Male");
		
		String xml= MyUtil.pojoToxml(pojo);
		System.out.println(xml);
		SamplePojo pojo1= (SamplePojo) MyUtil.xmlToPojo(xml, SamplePojo.class);
		System.out.println(pojo1.toString());
		
		String json= MyUtil.pojoToJsonString(pojo);
		System.out.println(json);
		SamplePojo pojo2= (SamplePojo) MyUtil.jsonToPojo(json, pojo.getClass());
		System.out.println(pojo2);
	}
}
