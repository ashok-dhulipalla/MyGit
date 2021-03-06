package com.ashok.util.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;

public class serviceUtil {

	private static RequestBodyEntity callPostService(String url,Map<String,String> headers, Map<String,Object> params)
	{
		StringBuilder paramString= new StringBuilder();
		Iterator<String> keys = params.keySet().iterator();
		while(keys.hasNext())
		{
			String key= keys.next();
			if(paramString.length() != 0)
				paramString.append("&");
			paramString.append(key+"="+params.get(key));
		}
		//Integer cnt = Integer.valueOf(String.valueOf(params.get("count")));
		Unirest.setTimeouts(0, 0);
		return Unirest.post(url)
				.headers(headers)
				.body(paramString.toString());
		

	}

	public static HttpResponse<String> callSynServiceAsString(String method, String url,Map<String,String> headers, Map<String,Object> params) throws UnirestException
	{
		if(method.equalsIgnoreCase("POST"))
			return callPostService(url, headers, params).asString();
		else
			return callGetService(url, headers, params).asString();
	}
	
	public static HttpResponse<InputStream> callSynServiceAsStream(String method, String url,Map<String,String> headers, Map<String,Object> params) throws UnirestException
	{
		if(method.equalsIgnoreCase("POST"))
			return callPostService(url, headers, params).asBinary();
		else
			return callGetService(url, headers, params).asBinary();
	}
	
	public static Future<HttpResponse<String>> callAsynServiceAsString(String method, String url,Map<String,String> headers, Map<String,Object> params) throws UnirestException
	{
		if(method.equalsIgnoreCase("POST"))
		{
			return callPostService(url, headers, params).asStringAsync();
		}
		else
			return callGetService(url, headers, params).asStringAsync();
	}
	
	public static Future<HttpResponse<InputStream>> callAsynServiceAsStream(String method, String url,Map<String,String> headers, Map<String,Object> params) throws UnirestException
	{
		if(method.equalsIgnoreCase("POST"))
			return callPostService(url, headers, params).asBinaryAsync();
		else
			return callGetService(url, headers, params).asBinaryAsync();
	}

	private static HttpRequest callGetService(String url, Map<String,String> headers, Map<String,Object> params)
	{
		Unirest.setTimeouts(0, 0);
		return Unirest.get(url).headers(headers)
				.queryString(params);
	}
	
	public static void main(String[] args) throws UnirestException, IOException {
		HttpResponse<String> res = callSynServiceAsString("GET", "http://unirest.io/java.html", null, null);
		System.out.println(res.getBody());
		
		ExecutorService exs= Executors.newFixedThreadPool(4);
	}
}
