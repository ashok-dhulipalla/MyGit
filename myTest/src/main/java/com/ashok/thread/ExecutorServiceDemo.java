package com.ashok.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService exs= Executors.newFixedThreadPool(5);
		exs.submit(new RunnableDemo());
		Future<Integer> sum = exs.submit(new CallableDemo(12, 12));
		System.out.println(sum.get());
		exs.shutdown();
	}
}
class RunnableDemo implements Runnable
{
	@Override
	public void run() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("callled Runnable");
	}
}
class CallableDemo implements Callable<Integer>
{
	Integer i= null;
	Integer j= null;
	
	public CallableDemo(Integer i, Integer j) {
		this.i= i;
		this.j= j;
	}
	
	@Override
	public Integer call() throws Exception {
		
		return i+j;
	}
}
