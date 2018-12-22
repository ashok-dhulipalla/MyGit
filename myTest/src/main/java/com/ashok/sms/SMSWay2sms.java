package com.ashok.sms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection; 

/**
 *
 * @author MKS
 */
public class SMSWay2sms {

    /**
     * @param args the command line arguments
     * @throws IOException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
/*    	String pi = "\u03c0";
    	System.out.println(pi);*/
    	FileReader reader= new FileReader(new File("/home/ashok/Documents/contacts/segregated.txt"));
    	BufferedReader br= new BufferedReader(reader);
    	String line= null;
    	int count= 10;
    	while((line= br.readLine()) != null)
    	{
    		if(!line.equals(""))
    		{
    			//Thread.sleep(600000);
    			String msg;
/*    			if(count%10 == 0)
    				msg="watch%20the%20video%20https://youtu.be/jXtZ0cgDit4%20myChannel";
    			else if(count%9 == 0)
    				msg="subscribe%20and%20share%20https://youtu.be/jXtZ0cgDit4%20Like%20it";
    			else if(count%8 == 0)
    				msg="share%20to%20ur%20friends%20https://youtu.be/jXtZ0cgDit4%20share%20to%20ur%20friends";
    			else if(count%7 == 0)
    				msg="Did%20u%20see%20this%20https://youtu.be/jXtZ0cgDit4%20Did%20u%20see%20this";
    			else if(count%6 == 0)
    				msg="Go%20learn%20https://youtu.be/jXtZ0cgDit4%20Go%20learn";
    			else if(count%5 == 0)
    				msg="click%20the%20link%20https://youtu.be/jXtZ0cgDit4%20click%20the%20link";
    			else if(count%4 == 0)
    				msg="link%20to%20be%20shared%20https://youtu.be/jXtZ0cgDit4%20watch%20and%20shARE";
    			else if(count%3 == 0)
    				msg="https://youtu.be/jXtZ0cgDit4";
    			else if(count%2 == 0)
    				msg="Go%20to%20Link%20https://youtu.be/jXtZ0cgDit4%20and%20subscribe";
    			else
    				msg="Subscribe%20my%20channel%20https://youtu.be/jXtZ0cgDit4";
    			count++;
    			System.out.println("count: "+count);*/
    			String number= line.split(",")[1];
    			//String number= "9182186636";
    			System.out.println(line.split(",")[1]);
    			for(int j= 0;j < 2;j++)
    			{
    				if(j == 0)
    					msg="Hiii,";
    				else
        			msg="https://youtu.be/3uRIhIBramY%20Find%20Nth%20Highest%20Salary%20In%20SQL%20Subscribe";
        	        try {
        	        	URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile=9603680245&Password=D3266D&Key=dhuli8FU9j3tbHAur6oq&Message="+msg+"&To="+number+"");
        	            URLConnection urlcon = url.openConnection();
        	            InputStream stream = urlcon.getInputStream();
        	            int i;
        	            String response="";
        	            while ((i = stream.read()) != -1) {
        	                response+=(char)i;
        	            }
        	            System.out.println(response);
        	        } catch (IOException e) {
        	            System.out.println(e.getMessage()+" error");
        	        }
    			}
//    			break;
    		}

    	}

    }
    
}
                            
