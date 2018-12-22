package com.ashok.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*		System.out.println("Join method test");
		Threading t1= new Threading();
		Thread tt1= new Thread(t1, "nameOfThread");
		System.out.println(new Date().getTime());
		long startTime = new Date().getTime();
		t1.start();
		tt1.start();
		t1.join();
		tt1.join();
		System.out.println((new Date().getTime())-startTime);*/

		//countdownlatch test
		/*		CountDownLatch countLatch= new CountDownLatch(2);
		Thread t1= new CountDownLatchTest(countLatch);
		t1.setName("Thread 1");
		Thread t2= new CountDownLatchTest(countLatch);
		t2.setName("Thread 2");

		t1.start();
		t2.start();

		countLatch.await();
		System.out.println("Done");*/
		//-----------------------------------------

		//wait notify notifyAll test
		Object obj= new Object();
		Thread t1= new wiatNotifyNotifyAllTest1(obj);
		Thread t2= new wiatNotifyNotifyAllTest2(obj);
		System.out.println("start thread1");
		t1.start();
		System.out.println("sleep for 3 seconds");
		Thread.sleep(3000);
		System.out.println("start thread2");
		t2.start();
		//-------------------------
		//----------callable test----------------
/*		String word = "Ashok kumar dhulipalla";
		WordLengthCallable callable = new WordLengthCallable(word);
		System.out.println(callable.call());*/
		//---------------------------------------
		//------------------thread pool-----------
/*		ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new ThreadpoolTest();
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");*/
        //-----------------------------------------------
	}
}
class ThreadpoolTest implements Runnable
{

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class WordLengthCallable implements Callable {
	private String word;
	public WordLengthCallable(String word) {
		this.word = word;
	}
	public Integer call() {
		return Integer.valueOf(word.length());
	}
}
class wiatNotifyNotifyAllTest1 extends Thread{

	private Object obj;
	public wiatNotifyNotifyAllTest1(Object obj)
	{
		this.obj= obj;
	}
	public void run() {
		synchronized(obj)
		{
			try {
				System.out.println("Thread1 going to blocked state");
				obj.wait();
				System.out.println("Thread1 is alive");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(this.getClass());
			System.out.println("Thread1");
			System.out.println("Thread1 calling notify");
			obj.notify();
		}
	}
}

class wiatNotifyNotifyAllTest2 extends Thread{

	private Object obj;
	public wiatNotifyNotifyAllTest2(Object obj)
	{
		this.obj= obj;
	}
	public void run() {
		synchronized(obj)
		{
			System.out.println("Thread2 calling notify");
			obj.notify();
			try {
				System.out.println("Thread2 going to blocked state");
				obj.wait();
				System.out.println("Thread2 is alive");
				//System.out.println(this.getClass());
				System.out.println("Thread2");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class CountDownLatchTest extends Thread{

	private CountDownLatch countLatch;
	public CountDownLatchTest(CountDownLatch countLatch)
	{
		this.countLatch= countLatch;
	}
	public void run() {
		try {

			Thread.sleep(2000);
			System.out.println("countdown "+currentThread().getName());
			countLatch.countDown();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Threading extends Thread{
	public void run()
	{
		for(int i= 0; i< 100000;i++)
			System.out.println(currentThread().getName());
	}
}
