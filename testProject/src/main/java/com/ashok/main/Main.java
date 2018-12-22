package com.ashok.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	static Logger logger= LoggerFactory.getLogger(Main.class);

/*	public static void main(String[] args) throws SQLException, ClassNotFoundException, MyUtilException, IOException
	{
		MyUtil.loadLog4JFile(Main.class,"/log4j.properties");
		
		logger.info("main class");
		System.out.println(MyUtil.getMysqlLocalConnection("mysql"));
		
		System.out.println(MyUtil.getPsqlLocalConnection());
		
		//System.out.println(MyUtil.getSqlConnection("192.168.32.225", 1433, "LTF_Sangam_Rel", "testuser", "testuser"));
		
		System.out.println(MyUtil.getClassPathOfFile(Main.class,"/testFile.txt"));
		
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
		System.out.println(MyUtil.addValuesInList(listInt, 5, 2));
		System.out.println(MyUtil.addValuesInList(listInt));
		
		Properties properties = MyUtil.loadPropertyFile(Main.class, "/myUtil.properties");
		String val = properties.getProperty("firstPropery");
		String val2 = properties.getProperty("secondPropery");
		System.out.println(val+ " "+val2);
		PrintWriter wr= new PrintWriter(new File("uploadData.txt"));
		for(int i= 1; i <= 6 ;i++)
		{
			for(int j= 1; j <= 27643 ;j++)
			{
				for(int k= 1; k <= 2 ;k++)
				{
					wr.write(i+"	"+j+"	"+k+"\n");
					System.out.println(i+"	"+j+"	"+k);
				}
			}
		}
		wr.flush();
	}*/
	
	   public static void main(String[] args) throws Exception { //Delimiter used in CSV file
		   
		    final String COMMA_DELIMITER = ",";
		
		    final String NEW_LINE_SEPARATOR = "\n";
		
		    //CSV file header
		    final String FILE_HEADER = "Version Id*,Branch Code*,Branch Name,Pin Code Code*,Pin Code,Source Code*,Source Name,YesNo Code*,YesNo Name,Unique ID";
		    
		            FileWriter fileWriter = null;
		    
		            try {
		    
		                fileWriter = new FileWriter("/home/ashok/Downloads/ValidGeoLimitGrid.csv");
		                
		                fileWriter.append("* means mandatory.");
		                fileWriter.append(NEW_LINE_SEPARATOR);
		                fileWriter.append(NEW_LINE_SEPARATOR);
		                
		                //Write the CSV file header
		                fileWriter.append(FILE_HEADER.toString());
		    
		                //Add a new line separator after the header
		                fileWriter.append(NEW_LINE_SEPARATOR);
		                
		        		for(int i= 1; i <= 6 ;i++)
		        		{
		        			for(int j= 1; j <= 27643 ;j++)
		        			{
		        				for(int k= 1; k <= 2 ;k++)
		        				{
		        					fileWriter.append(","+i+",,"+j+",,"+k+",,"+ ((int)(Math.random()*10)%2 == 0 ? 0:1));
		        					fileWriter.append(NEW_LINE_SEPARATOR);
		        					System.out.println(","+i+",,"+j+",,"+k+",,"+ ((int)(Math.random()*10)%2 == 0 ? 0:1));
		        				}
		        			}
		        		}
		    
		                System.out.println("CSV file was created successfully !!!");
		    
		            } catch (Exception e) {
		    
		                System.out.println("Error in CsvFileWriter !!!");
		    
		                e.printStackTrace();
		    
		            } finally {
		    
		                 
		    
		                try {
		    
		                    fileWriter.flush();
		    
		                    fileWriter.close();
		    
		                } catch (IOException e) {
		    
		                    System.out.println("Error while flushing/closing fileWriter !!!");
		    
		                    e.printStackTrace();
		    
		                }
		    
		            }
		    
		        }
	   }
