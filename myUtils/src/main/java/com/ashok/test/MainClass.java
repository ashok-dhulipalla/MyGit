package com.ashok.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ashok.util.webservice.serviceUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		MainClass mainclass = new MainClass();
//		mainclass.testUnirest();
		mainclass.testUnirestZain();
	}
	
	private void testUnirestZain() {
		try {
			List<Future<HttpResponse<String>>> lst = new ArrayList<>();
			for(int i = 1; i <= 10;i++)
			{
				System.out.println("starting thread: "+i);
				Map<String,String> headers= new HashMap<>();
				headers.put("content-type", "application/x-www-form-urlencoded");
				Map<String,Object> params= new HashMap<>();
				params.put("count", i);
				params.put("waitingTime", 10);
				Future<HttpResponse<String>> res;
	
				res= serviceUtil.callAsyncServiceAsString("POST", "http://localhost:8080/tomcatTest/tomcatTestServlet", headers, params);
				//System.out.println(res.get().getBody());
				lst.add(res);
				if(i % 5 == 0)
					Thread.sleep(5000);
				
//				Unirest.shutdown();
			}
			for(Future<HttpResponse<String>> res1: lst)
			{
				new Thread(new ResponseFuture(res1)).start();
			}
			System.out.println("done");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void testUnirest() {

		/*ExecutorService exs= Executors.newFixedThreadPool(21);
		for(int i = 1; i <= 20;i++)
		{
			exs.submit(new RunnableDemo(i));
			if(i%5 == 0)
				Thread.sleep(1000);
		}*/
		//exs.awaitTermination(20, TimeUnit.SECONDS);
		//System.out.println("Done");
		//Unirest.setDefaultHeader("content-type", "application/x-www-form-urlencoded");
		try {
			List<Future<HttpResponse<String>>> lst = new ArrayList<>();
			for(int i = 1; i <= 500;i++)
			{
				System.out.println("starting thread: "+i);
				Map<String,String> headers= new HashMap<>();
				headers.put("content-type", "application/x-www-form-urlencoded");
				Map<String,Object> params= new HashMap<>();
				params.put("count", i);
				params.put("waitingTime", 10);
				Future<HttpResponse<String>> res;

				res= serviceUtil.callAsyncServiceAsString("POST", "http://localhost:8080/tomcatTest/tomcatTestServlet", headers, params);
				//System.out.println(res.get().getBody());
				lst.add(res);
				if(i % 5 == 0)
					Thread.sleep(1000);
			}
			for(Future<HttpResponse<String>> res1: lst)
			{
				new Thread(new ResponseFuture(res1)).start();
			}
			System.out.println("done");
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /* catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	

}
class ResponseFuture implements Runnable
{
	private Future<HttpResponse<String>> res= null;
	private static Integer count= 0;
	private static Integer successcount= 0;

	public ResponseFuture(Future<HttpResponse<String>> res) {
		this.res= res;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		try {
			System.out.println("response: "+res.get().getBody());
			successcount++;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			count++;
		}
		System.out.println("success count: "+successcount);
		System.out.println("failed count: "+count);
	}
}
class RunnableDemo implements Runnable
{
	private Integer count= null;

	public RunnableDemo(Integer count) {
		this.count= count;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		System.out.println("starting thread: "+count);
		Map<String,String> headers= new HashMap<>();
		headers.put("content-type", "application/x-www-form-urlencoded");
		Map<String,Object> params= new HashMap<>();
		params.put("count", count);
		params.put("waitingTime", 10);
		try {

			Future<HttpResponse<String>> res = serviceUtil.callAsyncServiceAsString("POST", "http://localhost:8080/tomcatTest/tomcatTestServlet", headers, params);
			System.out.println("ended thread: "+count);
			System.out.println("response: "+res.get().getBody());

			/*HttpResponse<String> respsync = serviceUtil.callSynServiceAsString("POST", "http://localhost:8080/tomcatTest/tomcatTestServlet", headers, params);
			System.out.println("ended syncthread: "+count);
			System.out.println("response: "+respsync.getBody());*/
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
