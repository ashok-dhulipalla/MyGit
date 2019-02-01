package com.park.util;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {

	public static Logger logger= null;
	
	static {
		PropertyConfigurator.configure(LogUtil.class.getClassLoader().getResource("log4j.properties"));
		logger= Logger.getLogger("com.park");
	}
	
}
