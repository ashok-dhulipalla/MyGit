package com.ashok.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class blankController {
	
	@RequestMapping(value = "/msg/{message}", method = RequestMethod.GET)
	@ResponseBody
	public String getRequest(@PathVariable(value= "message") String message)
	{
		System.out.println(message);
		return "Message is "+message+"\n";
	}
	
	@RequestMapping(value = "/postRequest", method = RequestMethod.POST)
	@ResponseBody
	public String postRequest(HttpServletRequest request)
	{
		String name = request.getParameter("firstName")+" "+request.getParameter("lastName");
		return "name is "+name+"\n";
	}
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile fileReceived)
	{

		ResponseEntity<String> responseEntity= null;
		JSONObject json= new JSONObject();
		try{

			String filePath= File.separator+"home"+File.separator+System.getProperty("user.name")+File.separator+fileReceived.getOriginalFilename();

			BufferedOutputStream os= new BufferedOutputStream(new FileOutputStream(filePath));
			os.write(fileReceived.getBytes());
			os.flush();
			json.put("status", "success");
			json.put("uploadedPath", filePath);
			responseEntity= new ResponseEntity<String>(json.toString()+"\n", HttpStatus.OK);

		}
		catch (Exception e) {
			e.printStackTrace();
			json= new JSONObject();
			json.put("status", "error");
			json.put("errMessage", e.getMessage()+"");
			responseEntity= new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}

