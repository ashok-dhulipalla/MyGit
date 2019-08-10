package com.ashok.util.convert;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertUtil {

	public static void main(String[] args) {
		
	}
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
	@SuppressWarnings("unchecked")
	public static <T> T xmlToPojo(String xml,Class<T> pojoClass) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(pojoClass);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		return (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
		
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
	public static <T> T jsonToPojo(String json,Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return (T)mapper.readValue(json, pojoClass);
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
	public static <T> T jsonToPojo(File jsonFile,Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException
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
	public static <T> T jsonToPojo(URL jsonUrl,Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonUrl, pojoClass);
	}

	public static Map<String,Object> pojoToMap(Object pojoObj)
	{
		ObjectMapper mapper= new ObjectMapper();
		return mapper.convertValue(pojoObj, new TypeReference<Map<String, Object>>(){});
	}
	
	public static <T> T mapToPojo(Map<String,Object> map,Class<T> pojoClass)
	{
		ObjectMapper mapper= new ObjectMapper();
		return mapper.convertValue(map,pojoClass);
	}
	
	public static String fileToString(File file) throws IOException
	{
		byte[] fileInBytes= new byte[(int)file.length()];
		InputStream is= new FileInputStream(file);
		is.read(fileInBytes);
		is.close();

		String content= new String(fileInBytes);
		return content;
	}

	public static String inputStreamToString(InputStream inputStream) throws IOException
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream(); 
	    byte[] buffer = new byte[0xFFFF];
	    for (int len = inputStream.read(buffer); len != -1; len = inputStream.read(buffer)) { 
	        os.write(buffer, 0, len);
	    }

		String content= new String(os.toByteArray());
		return content;
	}
	
	public static String bytesToBase64EncodeString(byte[] imageBytes) {
		
		return Base64.getEncoder().encodeToString(imageBytes);
		
	}

	public static byte[] encodedStringToBytes(String imageString) {
		
		return Base64.getDecoder().decode(imageString);
	}
}
