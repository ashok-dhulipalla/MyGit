package com.ash.xmlPojoConverter;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException
    {
    	/**
    	 * @XmlAccessorType
    	 * 1. PUBLIC_MEMBER – Every public getter/setter pair 
    	 * and every public field will be automatically bound to XML, 
    	 * unless annotated by XmlTransient.
    	 * 
    	 * 2. FIELD – Every non static, non transient field in a JAXB-bound class 
    	 * will be automatically bound to XML,
    	 * unless annotated by XmlTransient.
    	 * 
    	 * 3. PROPERTY – Every getter/setter pair in a JAXB-bound class 
    	 * will be automatically bound to XML, 
    	 * unless annotated by XmlTransient.
    	 * 
    	 * 4. NONE – None of the fields or properties is bound to XML 
    	 * unless they are specifically annotated with some of the JAXB annotations.
    	 */
        String xml = 
        		"<employee id=\"1234\">" + 
        		"	<name>ashok</name>" + 
        		"	<age>26</age>" + 
        		"   <company id=\"company_id\">Company name</company>" +
        		"</employee>";
        
        //1. Create POJO or bind the schema and generate the classes
        //2. Create the JAXBContext object
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        //3. Create the Unmarshaller objects
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        //4. Call the unmarshal method
        Employee pojo = (Employee)unmarshaller.unmarshal(new StringReader(xml));
        //5. Use getter methods of POJO to access the data
        System.out.println(pojo.getName());
        System.out.println(pojo.getAge());
        System.out.println(pojo.getId());
        System.out.println(pojo.getCompany().getName());
        System.out.println(pojo.getCompany().getId());
        
        
        //1. Create POJO or bind the schema and generate the classes
        //2. Create the JAXBContext object
        //3. Create the Marshaller objects
        Marshaller marshaller = jaxbContext.createMarshaller();
        //4. Create the content tree by using set methods
        pojo.setName("SkillSetGo");
        pojo.setAge(3);
        pojo.setId(54321);
        Company company = new Company();
        company.setName("Test company name demo");
        company.setId("test_id");
        pojo.setCompany(company);
        //5. Call the marshal method
        StringWriter sw = new StringWriter();
        marshaller.marshal(pojo, sw);
        System.out.println(sw.toString());
    }
}
