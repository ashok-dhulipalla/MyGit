package com.ashok.util.configFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.ashok.util.myUtil.MyUtil;

public class ConfigFilesUtil {

	/**
	 * 	This method tries to read the log4j file from the root path of the build folder<br>
	 * (i.e. /bin, /build, /WEB-INF/classes) in case name starts with '/';<br>
	 * Else it reads from the package of given class.
	 * @param <T>
	 * @param anyClassInAClassPath
	 * @param fileName
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	public static <T> void loadLog4JFile(Class<T> anyClassInAClassPath, String fileName) throws FileNotFoundException, Exception
	{
        PropertyConfigurator.configure(getClassPathOfFile(anyClassInAClassPath, fileName));
	}
	public static void loadLog4JFile(String fileName) throws FileNotFoundException, Exception
	{
        PropertyConfigurator.configure(getClassPathOfFile(MyUtil.class, "/"+fileName));
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
	 * @throws Exception
	 */
	public static <T> Properties loadPropertyFile(Class<T> anyClassInAClassPath, String fineName) throws IOException, Exception
	{
		if(anyClassInAClassPath == null)
			throw new Exception("Class can not be null.");
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
	
	/**
	 * This method tries to read the resource file from the root path of the build folder<br>
	 * (i.e. /bin, /build, /WEB-INF/classes) in case name starts with '/';<br>
	 * Else it reads from the package of given class.
	 * @param <T>
	 * 
	 * @param name
	 * @return absolute path
	 * @throws FileNotFoundException
	 * @throws Exception 
	 * 
	 */
	public static <T> String getClassPathOfFile(Class<T> thisClass,String name) throws FileNotFoundException, Exception
	{
		if(thisClass == null)
			throw new Exception("Class should not be null.");
		
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

}
