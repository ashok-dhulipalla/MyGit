package com.ashok.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.zip.CRC32;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;


public class Main {

	/*	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
				Calendar cal = Calendar.getInstance();
		Date d= new Date();
		String start_yymm= "";
		if(d.getMonth() == 0)
			start_yymm= (d.getYear()+1900)+"-12";
		else if(d.getMonth() < 10)
			start_yymm= (d.getYear()+1900)+"-0"+String.valueOf(d.getMonth());
		else
			start_yymm= (d.getYear()+1900)+"-"+String.valueOf(d.getMonth());
		String end_yymm= "";
		if(d.getMonth() == 0)
			start_yymm= (d.getYear()+1900)+"-12";
		else
			start_yymm= (d.getYear()+1900)+"-0"+String.valueOf(d.getMonth());

		System.out.println(d.getYear()+1900);
		System.out.println(d.getMonth()+1);


		//Date d = new SimpleDateFormat("yyyy-MM-dd").parse("1994-07-05");
		String d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
//		System.out.println(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(d));
		System.out.println(d);


			       Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.MONDAY, -1);

	        String month = "" + (cal.get(Calendar.MONTH) + 1);
	        month = month.length() == 2 ? month : "0" + month;
	        String toDate = cal.get(Calendar.YEAR) + "-" + month;

	        System.out.println(toDate);

	        String duration = "6";

	        cal.add(Calendar.MONTH, Integer.parseInt("-"+ duration) + 1);
	        month = "" + (cal.get(Calendar.MONTH) + 1);
	        month = month.length() == 2 ? month : "0" + month;
	        String fromDate = cal.get(Calendar.YEAR) + "-" + month;

	        System.out.println(fromDate);

				System.out.println((2017/100)*100);

		Date date= new Date();
		System.out.println("date: "+date);
		System.out.println("date.getTime(): "+date.getTime());
		System.out.println("date.getDate(): "+date.getDate());
		System.out.println("date.getTimezoneOffset(): "+date.getTimezoneOffset());
		System.out.println("date.getYear()+1900: "+(date.getYear()+1900));
		System.out.println("date.toString(): "+date.toString());

		date.setTime(1523613681106L);
		System.out.println("date.getTime(): "+date.getTime());

		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		System.out.println("\ncal.getTime() "+cal.getTime());
		System.out.println("cal.getTimeInMillis() "+cal.getTimeInMillis());
		System.out.println("cal.getFirstDayOfWeek() "+cal.getFirstDayOfWeek());
		System.out.println("cal.getCalendarType() "+cal.getCalendarType());
		System.out.println("cal.getMaximum(Calendar.DATE) "+cal.getMaximum(Calendar.DATE));
		cal.setFirstDayOfWeek(5);
		System.out.println("\ncal.getTimeInMillis() "+cal.getTimeInMillis());
		System.out.println("cal.getFirstDayOfWeek() "+cal.getFirstDayOfWeek());



	}*/
	public static void main(String[] args) throws Exception {
		/*		Class.forName("org.postgresql.Driver");
		Connection connection=DriverManager.getConnection("jdbc:postgresql://172.18.0.200:5434/WLH_Dev","wlh_bre","wlh_bre");
		insert(connection,"1995:05:02:24:12:12",12);
//		insert(connection,"2018-04-16 12:26:00");
		select(connection);
		//select(connection,"2018-04-16 12:26:19" );
		 * 
		 */	
		/*		Calendar cal = Calendar.getInstance();
		String dt = "" + cal.get(Calendar.YEAR) + ":" + (cal.get(Calendar.MONTH)+1) + ":" + cal.get(Calendar.DATE)+ ":" + cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
		System.out.println(dt);*/
		
		//birtReport();
		/*Calendar cal= null;
		cal = getDateIPToCalendar("2018:04:26");
		cal.setTimeZone(TimeZone.getTimeZone("ACT"));
		System.out.println(cal.getTime());

		cal= Calendar.getInstance(TimeZone.getTimeZone("UCT"));
		//cal.setTimeZone(TimeZone.getTimeZone("ACT"));
//		cal.add(Calendar.HOUR_OF_DAY, Integer.valueOf("-"+String.valueOf(cal.get(Calendar.HOUR_OF_DAY))));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));*/
/*		
		Calendar startDate = getDateIPToCalendar("2018:4:26:0:0:0");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startDate.getTime()) + " " + TimeZone.getDefault().getID());
		System.out.println(new Date(startDate.getTimeInMillis()));*/
		
		//Long.parseLong("null");
		
		//System.out.println(17 >> 2);
		
/*		String str1="192.168.0.201";
		String str2="255.255.255.0";
		String[] command1 = { "netsh", "interface", "ip", "set", "address",
		"name=", "Local Area Connection" ,"source=static", "addr=",str1,
		"mask=", str2};
		Process pp = java.lang.Runtime.getRuntime().exec(command1);*/
		
/*		String e = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
		java.util.Date d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(e);
		
		System.out.println(e);
		System.out.println(d);*/
/*		String str= "msg1";
		CRC32 crc32= new CRC32();
		crc32.update(str.getBytes());
		System.out.println(crc32.getValue());
		
		str= "msg1";
		CRC32 crc321= new CRC32();
		crc321.update(str.getBytes());
		System.out.println(crc321.getValue());*/
		
		//birtReport();
		
	}
	public static Calendar getDateIPToCalendar(String ipFormatDate) throws Exception {
		// if (ipFormatDate == null || ipFormatDate.trim().length() == 0 ||
		// ipFormatDate.equals(CMSConstants.IP_NULL))
		// return null;

		Calendar cal = null;
		try {
			// Copied form GlobalFunction's.
			StringTokenizer st = new StringTokenizer(ipFormatDate, ":");
			int[] intArr = new int[6];
			int i = 0;
			while (st.hasMoreTokens()) {
				intArr[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			i = 0;
			cal = Calendar.getInstance();
			cal.set(intArr[i++], intArr[i++] - 1, intArr[i++], intArr[i++], intArr[i++], intArr[i]);
			// added by: Vibhu Date: 26-Feb-09
			cal.set(Calendar.MILLISECOND, 0);
		} catch (Exception e) {
			// Log the Exception
			throw e;
		}
		return cal;
	}
	public static void birtReport()
	{

		IReportEngine engine=null;
		EngineConfig config = null;

		try{
			
			config = new EngineConfig( );			
			//config.setBIRTHome("/home/ashok/ReportEngine");
			config.setLogConfig("/home/ashok/birt/log", java.util.logging.Level.FINEST);
			Platform.startup( config );
			IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
			engine = factory.createReportEngine( config );		

			IReportRunnable design = null;
			design = engine.openReportDesign("/home/ashok/birt/new_report.rptdesign"); 
			IRunAndRenderTask task = engine.createRunAndRenderTask(design); 		

			HTMLRenderOption options = new HTMLRenderOption();		
			options.setOutputFileName("/home/ashok/birt/report.html");
			options.setOutputFormat("html");
			PDFRenderOption options1 = new PDFRenderOption();
			options1.setOutputFileName("/home/ashok/birt/test.pdf");
			options1.setOutputFormat("pdf");

			task.setRenderOption(options);
/*	        task.setParameterValue("app_id", "52353");
	        task.setParameterValue("app_version_id", "1");
	        task.setParameterValue("allow_sc_access", "0");*/
	       
			task.run();
			task.close();
			engine.destroy();
			System.out.println("done");
		}catch( Exception ex){
			ex.printStackTrace();
		}		
		finally
		{
			Platform.shutdown( );
		}
	}
	public static void select(Connection connection) throws SQLException, ParseException {

		boolean result = false;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String query = "select * from DAKTest3";
		preparedStatement = connection.prepareStatement(query);
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getTimestamp("prop2_date"));
		}
	}
	public static void insert(Connection connection,String dateFormat,int entityId) throws SQLException, ParseException {

		boolean result = false;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String query = "INSERT INTO wlh_bre.daktest3\n" + 
				"(created_by, creation_date, owner, owner_name, last_modified_by, last_modified_date, read_only, business_status, lcm_status, url,  entityid, entityversion, active, lastmodifiedtime, ir_last_approved_by, ir_approval_status, ir_last_approved_date,prop1_string,prop2_date)\n" + 
				"VALUES('System', now(), 'a', 'Common', 'System', now(), NULL, 'Active', NULL, NULL,    "+entityId+", 0, 'A', 'NULL', 'NULL', 'approved', null,'ashok',?);";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setTimestamp(1, new java.sql.Timestamp(new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").parse(dateFormat).getTime()));
		preparedStatement.execute();
	}






	public static void insert(Connection connection, String date) throws SQLException, ParseException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String query = "insert into test values(?)";
		preparedStatement = connection.prepareStatement(query);

		Timestamp time = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date).getTime());

		preparedStatement.setTimestamp(1, time);
		preparedStatement.execute();
	}

	public static void select(Connection connection, String date) throws SQLException, ParseException {

		boolean result = false;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		//		String query = "select * from DAKTest3";

		String query = "select a from test where a < ?";
		preparedStatement = connection.prepareStatement(query);

		Timestamp time = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date).getTime());
		preparedStatement.setTimestamp(1, time);

		rs = preparedStatement.executeQuery();



		while (rs.next()) {
			//			System.out.println(rs.getTimestamp("prop2_date"));
			System.out.println(rs.getTimestamp("a"));
		}
		System.out.println("done");
	}










}

