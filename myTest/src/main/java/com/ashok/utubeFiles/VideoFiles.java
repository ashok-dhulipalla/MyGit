package com.ashok.utubeFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class VideoFiles {

	public static void main(String[] args){
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("/home/ashok/vid/metadata/fileAndLink.txt"));
			String fileName;
			while((fileName= reader.readLine()) != null)
			{
				BufferedWriter out = new BufferedWriter(new FileWriter("/home/ashok/vid/"+fileName));
				String content="<!DOCTYPE html>\n" + 
						"<html>\n" + 
						"<body>\n\n";
				String link= reader.readLine();
				for(int i= 0; i < 6;i++)
				{
					content+= "<iframe width=\"560\" height=\"250\" \n" + 
							"src=\""+link+"?\n" + 
							"autoplay=0&loop=0&controls=1&vq=tiny\" frameborder=\"0\" allow=\"autoplay; \n" + 
							"encrypted-media\" allowfullscreen></iframe>\n\n";
				}
				content+="</body>\n" + 
						"</html>";
				out.write(content);
				out.flush();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
