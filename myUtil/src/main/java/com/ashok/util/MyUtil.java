package com.ashok.util;

import java.beans.PropertyEditorManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.PropertyConfigurator;

import com.ashok.exception.MyUtilException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyUtil {

	/**
	 * @param pojo
	 * @return xml String
	 * @throws JAXBException
	 */
	public static String pojoToxml(Object pojo) throws JAXBException  {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(pojo.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(pojo, sw);
		return sw.toString();
		
	}
	/**
	 * 
	 * @param <T>
	 * @param xml
	 * @param pojoClass
	 * @return 
	 * @return poJo Object
	 * @throws JAXBException
	 */
	public static <T>  Object xmlToPojo(String xml,Class<T> pojoClass) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(pojoClass);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		return jaxbUnmarshaller.unmarshal(new StringReader(xml));
		
	}
	/**
	 * @param pojo
	 * @return json String
	 * @throws JsonProcessingException
	 */
	public static String pojoToJsonString(Object pojo) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(pojo);
	}
	/**
	 * @param pojo
	 * @param jsonOutPutFile
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void pojoToJsonFile(Object pojo,File jsonOutPutFile) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(jsonOutPutFile, pojo);
	}
	/**
	 * 
	 * @param <T>
	 * @param json
	 * @param pojoClass
	 * @return pojo Object
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> Object jsonToPojo(String json,Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return (Object)mapper.readValue(json, pojoClass);
	}
	/**
	 * 
	 * @param jsonFile
	 * @param pojoClass
	 * @return pojo Object
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> Object jsonToPojo(File jsonFile,Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonFile, pojoClass);
	}
	/**
	 * 
	 * @param <T>
	 * @param jsonUrl
	 * @param pojoClass
	 * @return pojo Object
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> Object jsonToPojo(URL jsonUrl,Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonUrl, pojoClass);
	}
	/**
	 * 
	 * @param host
	 * @param port
	 * @param databaseName
	 * @param userName
	 * @param password
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getMysqlConnection(String host,Integer port,String databaseName,String userName,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		String url="jdbc:mysql://"+host+":"+port+"/"+databaseName;
		return getConnection(url,userName,password);  
	}
	public static Connection getSqlConnection(String host,Integer port,String databaseName,String userName,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		String url="jdbc:sqlserver://"+host+":"+port+";databaseName="+databaseName;
		return getConnection(url,userName,password);  
	}
	/**
	 * 
	 * @param databaseName
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getMysqlLocalConnection(String databaseName) throws SQLException, ClassNotFoundException
	{
		return getMysqlConnection("localhost", 3306, databaseName, "root","9603689505");
	}
	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection(String url,String userName,String password) throws SQLException
	{
		return DriverManager.getConnection(url,userName,password);
	}
	/**
	 * 
	 * @param host
	 * @param port
	 * @param databaseName
	 * @param userName
	 * @param password
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getPsqlConnection(String host,Integer port,String databaseName,String userName,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://"+host+":"+port+"/"+databaseName;
		return getConnection(url,userName,password);  
	}
	/**
	 * 
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getPsqlLocalConnection() throws SQLException, ClassNotFoundException
	{
		return getPsqlConnection("localhost", 5432, "postgres","ashok","9603689505");
	}
	public static Connection getDerbyConnection(String databaseName) throws SQLException
	{
		//TODO
		String url="jdbc:derby:"+databaseName+";create=true";
		return DriverManager.getConnection(url);
	}
	/**
	 * This method tries to read the resource file from the root path of the build folder<br>
	 * (i.e. /bin, /build, /WEB-INF/classes) in case name starts with '/';<br>
	 * Else it reads from the package of given class.
	 * @param <T>
	 * 
	 * @param name
	 * @return absolute path
	 * @throws FileNotFoundException
	 * @throws MyUtilException 
	 * 
	 */
	public static <T> String getClassPathOfFile(Class<T> thisClass,String name) throws FileNotFoundException, MyUtilException
	{
		if(thisClass == null)
			throw new MyUtilException("Class should not be null.");
		
		URL res = null;
		if((res= thisClass.getResource(name)) == null)
		{
			if(name.startsWith("/"))
				throw new FileNotFoundException("File "+name+" not found in the source folders");
			else
				throw new FileNotFoundException("File "+name+" not found in the package: " + thisClass.getPackage());
		}
		return res.getPath();
	}
	/**
	 * 
	 * @param list Prints all values in the list
	 */
	public static <T> void printList(List<T> list)
	{
		printList(list, null, null);
	}
	/**
	 * 
	 * @param list Prints all values in the list which satisfies below condition
	 * @param condition
	 * 1 for Equal, Prints values where value == conditionValue<br>
	 * 2 for notEqual<br>
	 * 3 for lessThan<br>
	 * 4 for greaterThan<br>
	 * 5 for lessThanOrEqual<br>
	 * 6 for greaterThanOrEqual
	 * @param conditionValue
	 */
	public static <T> void printList(List<T> list,Integer condition, T conditionValue)
	{
		Stream<T> stream = list.stream();
		Stream<T> filter= null;
		System.out.println("---- Printing values from the list ----");
		filter= getFilteredStream(stream, condition, conditionValue);
		if(filter != null)
		{
			filter.forEach(e -> System.out.println(e));			
		}
		else
		{
			stream.forEach(e -> System.out.println(e));			
		}
	}
	
	/**
	 * 
	 * @param list Add all values in the list
	 * @return sum Sum of values in the list
	 */
	public static Integer addListValues(List<Integer> list)
	{
		return addListValues(list, null, null);
	}
	/**
	 * 
	 * @param Add all values in the list which satisfies below condition
	 * @param condition
	 * 1 for Equal, Prints values where value == conditionValue<br>
	 * 2 for notEqual<br>
	 * 3 for lessThan<br>
	 * 4 for greaterThan<br>
	 * 5 for lessThanOrEqual<br>
	 * 6 for greaterThanOrEqual
	 * @param conditionValue
	 * @return sum Sum of values
	 */
	public static Integer addListValues(List<Integer> list,Integer condition, Integer conditionValue)
	{
		Stream<Integer> stream = list.stream();
		Stream<Integer> filter= null;
		System.out.println("---- Adding values from the list ----");
		filter= getFilteredStream(stream, condition, conditionValue);
		if(filter != null)
		{
			return filter.mapToInt(e-> e.intValue()).sum();		
		}
		else
		{
			return stream.mapToInt(e-> e.intValue()).sum();			
		}
	}
	/**
	 * 
	 * @param stream
	 * @param condition
	 * @param conditionValue
	 * @return stream Filtered based on condition
	 */
	private static <T> Stream<T> getFilteredStream(Stream<T> stream, Integer condition, T conditionValue)
	{
		StringBuilder msg= new StringBuilder();
		if(condition != null && conditionValue != null)
		{
			msg.append("---- With Condition ");
			if(condition == 1) {
				msg.append("== "+conditionValue.toString());
				stream= stream.filter(e-> isEqual(e,conditionValue));				
			}
			if(condition == 2){
				msg.append("!= "+conditionValue.toString());
				stream= stream.filter(e-> !isEqual(e,conditionValue));
			}
			if(condition == 3) {
				msg.append("< "+conditionValue.toString());
				stream= stream.filter(e-> isLessThan(e,conditionValue));
			}
			if(condition == 4) {
				msg.append("> "+conditionValue.toString());
				stream= stream.filter(e-> isGreaterThan(e,conditionValue));
			}
			if(condition == 5) {
				msg.append("<= "+conditionValue.toString());
				stream= stream.filter(e-> isLessThan(e,conditionValue) || isEqual(e, conditionValue));
			}
			if(condition == 6) {
				msg.append(">= "+conditionValue.toString());
				stream= stream.filter(e-> isGreaterThan(e,conditionValue) || isEqual(e, conditionValue));
			}
			System.out.println(msg+" ----");
		}
		return stream;
	}
	/**
	 * 
	 * @param obj1 Compares obj1 with obj2
	 * @param obj2
	 * @return boolean
	 */
	public static boolean isEqual(Object obj1, Object obj2)
	{
		if(obj2 instanceof Integer)
		{
			return obj1 == obj2;
		}
		else if(obj2 instanceof String)
		{
			return ((String)obj1).compareToIgnoreCase((String)obj2) == 0;
		}
		return false;
	}
	/**
	 * 
	 * @param obj1 Compares obj1 with obj2
	 * @param obj2
	 * @return boolean
	 */
	public static boolean isLessThan(Object obj1, Object obj2)
	{
		if(obj2 instanceof Integer)
		{
			return (Integer)obj1 < (Integer)obj2;
		}
		else if(obj2 instanceof String)
		{
			return ((String)obj1).compareToIgnoreCase((String)obj2) < 0;
		}
		return false;
	}
	/**
	 * 
	 * @param obj1 Compares obj1 with obj2
	 * @param obj2
	 * @return boolean
	 */
	public static boolean isGreaterThan(Object obj1, Object obj2)
	{
		if(obj2 instanceof Integer)
		{
			return (Integer)obj1 > (Integer)obj2;
		}
		else if(obj2 instanceof String)
		{
			return ((String)obj1).compareToIgnoreCase((String)obj2) > 0;
		}
		return false;
	}
	/**
	 * 	This method tries to read the log4j file from the root path of the build folder<br>
	 * (i.e. /bin, /build, /WEB-INF/classes) in case name starts with '/';<br>
	 * Else it reads from the package of given class.
	 * @param <T>
	 * @param anyClassInAClassPath
	 * @param fileName
	 * @throws MyUtilException 
	 * @throws FileNotFoundException 
	 */
	public static <T> void loadLog4JFile(Class<T> anyClassInAClassPath, String fileName) throws FileNotFoundException, MyUtilException
	{
        PropertyConfigurator.configure(getClassPathOfFile(anyClassInAClassPath, fileName));
	}
	/**
	 * This method tries to read the properties file from the root path of the build folder<br>
	 * (i.e. /bin, /build, /WEB-INF/classes) in case name starts with '/';<br>
	 * Else it reads from the package of given class.
	 * 
	 * @param anyClassInAClassPath
	 * @param fineName
	 * @return properties
	 * @throws IOException
	 * @throws MyUtilException
	 */
	public static <T> Properties loadPropertyFile(Class<T> anyClassInAClassPath, String fineName) throws IOException, MyUtilException
	{
		if(anyClassInAClassPath == null)
			throw new MyUtilException("Class can not be null.");
		Properties properties= new Properties();
		InputStream res;
		if((res= anyClassInAClassPath.getResourceAsStream(fineName)) == null)
		{
			if(fineName.startsWith("/"))
				throw new FileNotFoundException("File "+fineName+" not found in the source folders");
			else
				throw new FileNotFoundException("File "+fineName+" not found in the package: " + anyClassInAClassPath.getPackage());
		}
		properties.load(res);
		return properties;
	}
}
