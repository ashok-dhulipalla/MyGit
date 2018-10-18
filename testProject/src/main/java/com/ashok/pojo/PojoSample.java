package com.ashok.pojo;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.ashok.util.MyUtil;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.api.json.JSONUnmarshaller;

@XmlRootElement(name="rootElement")
@XmlAccessorType(XmlAccessType.FIELD)
/*NONE	Only annotated fields and properites should be serialized>
FIELD	All fields (public or private) should be serialized>
PROPERTY	All properties (public or private) should be serialized>
PUBLIC_MEMBER	Public fields and properties>*/
public class PojoSample {

	String firstName;
	String middleName;
	String lastName;
	String gender;
	
	Integer age;
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

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PojoSample [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + "]";
	}
	public static void main(String[] args) throws JAXBException, IOException {
		
		MyUtil.printList(Arrays.asList(PojoSample.class.getDeclaredFields()));
		
		
		Object obj= new PojoSample();
		System.out.println(obj.getClass());
		
		PojoSample pojo= new PojoSample();
		pojo.setFirstName("Ashok");
		pojo.setMiddleName("Kumar");
		pojo.setLastName("Dhulipalla");
		pojo.setGender("Male");
		pojo.setAge(24);
		
		String xml= MyUtil.pojoToxml(pojo);
		System.out.println("pojoToXml: "+xml);
		PojoSample pojo1 = MyUtil.xmlToPojo(xml, PojoSample.class);
		System.out.println("xmlToPojo: "+pojo1.toString());
		
		String json= MyUtil.pojoToJsonString(pojo);
		System.out.println("pojoToJson: "+json);
		PojoSample pojo2= MyUtil.jsonToPojo(json, pojo.getClass());
		System.out.println("jsonToPojo: "+pojo2);
		
		Map<String, Object> map = MyUtil.pojoToMap(pojo);
		System.out.println("pojoToMap: "+map.toString());
		System.out.println("mapToPojo: "+MyUtil.mapToPojo(map, PojoSample.class));
		
		
		Class[] arr = { PojoSample.class };
		JSONJAXBContext jsonContext = new JSONJAXBContext(JSONConfiguration.natural().build(), arr);
		JSONUnmarshaller unmarshaller = jsonContext.createJSONUnmarshaller();
		PojoSample pojoTest= unmarshaller.unmarshalFromJSON(new StringReader("{\"firstName\":\"Ashok\",\"middleName\":\"Kumar\",\"lastName\":\"Dhulipalla\",\"gender\":\"Male\",\"age\":\"2.3\"}"), PojoSample.class);
		System.out.println("jsonToPojoTest: "+pojoTest);
	}
}
