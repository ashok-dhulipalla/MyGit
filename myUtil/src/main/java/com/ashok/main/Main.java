package com.ashok.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashok.exception.MyUtilException;
import com.ashok.util.MyUtil;

public class Main {
	
	static Logger logger= LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws SQLException, ClassNotFoundException, MyUtilException, IOException
	{
		MyUtil.loadLog4JFile(Main.class,"/log4j.properties");
		
		logger.info("main class");
		System.out.println(MyUtil.getMysqlLocalConnection("mysql"));
		
		System.out.println(MyUtil.getPsqlLocalConnection());
		
		//System.out.println(MyUtil.getSqlConnection("192.168.32.225", 1433, "LTF_Sangam_Rel", "testuser", "testuser"));
		
		System.out.println(MyUtil.getClassPathOfFile(Main.class,"testFile1.txt"));
		
		List<String> list= new ArrayList<>();
		list.add("Ashok");
		list.add("Kumar");
		MyUtil.printList(list, 6,"a");
		MyUtil.printList(list);
		
		List<Object> listObj= new ArrayList<>();
		listObj.add("ashok");
		listObj.add(22);
		listObj.add(32);
		listObj.add("ashokKumar");
		MyUtil.printList(listObj);
		
		List<Integer> listInt= new ArrayList<>();
		listInt.add(23);
		listInt.add(2);
		System.out.println(MyUtil.addListValues(listInt, 5, 2));
		System.out.println(MyUtil.addListValues(listInt));
		
		Properties properties = MyUtil.loadPropertyFile(Main.class, "/myUtil.properties");
		String val = properties.getProperty("firstPropery");
		String val2 = properties.getProperty("secondPropery");
		System.out.println(val+ " "+val2);
	}
}
