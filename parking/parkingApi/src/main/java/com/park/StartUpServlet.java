package com.park;

import java.io.IOException;

import javax.servlet.http.HttpServlet;

import com.properties.PropertyFile;

public class StartUpServlet extends HttpServlet{
	
	//private static Logger logger= LoggerFactory.getLogger(StartUpServlet.class);
	
	public void init()
	{
		try {
			PropertyFile.loadProperties("parking.properties");
			System.out.println("Properties loaded from parking.properties-----------------");
			//LogUtil.loadLog4JFile("log4j.properties");
			//logger.info("log4j properties loaded");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
