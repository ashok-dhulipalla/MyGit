package com.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyFile {

	private static Properties properties;

	public static void loadProperties(String fileName) throws IOException
	{
		InputStream inStream = PropertyFile.class.getClassLoader().getResourceAsStream(fileName);
		loadProperties(inStream);
	}
	
	public static void loadProperties(File file) throws IOException
	{
		InputStream inStream= new FileInputStream(file);
		loadProperties(inStream);
	}
	
	public static void loadProperties(InputStream inStream) throws IOException
	{
		try {
			if(properties == null)
				properties= new Properties();
			properties.load(inStream);
		} catch (IOException e) {
			throw new IOException("Error while loading properties");
		}
		System.out.println("properties loaded successfully");
	}
	
	public static void loadProperties(Properties properties) throws IOException
	{
		if(PropertyFile.properties == null)
			PropertyFile.properties= new Properties();
		PropertyFile.properties.putAll(properties);
		System.out.println("properties loaded successfully");
	}
	
	public static String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
	public static String getProperty(String key, String defaultVal)
	{
		return properties.getProperty(key,defaultVal);
	}
	
	public static String getProperty(String key,String arg0,String... moreArgs)
	{
		String[] args= new String[1+moreArgs.length];
		args[0]= arg0;
		for(int i= 0;i < moreArgs.length;i++)
		{
			args[i+1]= moreArgs[i];
		}
		return getProperty(key, args);
	}
	
	public static String getProperty(String key,String[] args)
	{
		String value= getProperty(key);
		if(value != null && args != null)
		{
			for(int i= 0;i < args.length;i++)
			{
				value= value.replace("{"+i+"}",args[i]);
			}
		}
		return value;
	}
	
	public static boolean isPropertiesLoaded()
	{
		if(properties == null || properties.isEmpty())
			return false;
		return true;
	}
}
