package com.ashok.main;

import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ashok.models.UserTEO;

public class TestMain
{
	public static void main(String[] args) throws Exception
	{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
		SqlSession session = sqlSessionFactory.openSession();

		//Create a new student object
		UserTEO user= new UserTEO();
		user.setId(1);
		user.setName("Ashok");
		user.setEmail("dhulipallaashokumar@gmail.com");
		user.setPassword("password");
		user.setCreation_date(new SimpleDateFormat("YYYY-MM-dd hh:ss:mm").format(new Date()));

		ExecutorService exs= Executors.newFixedThreadPool(10);
		for(int i= 1; i <= 1000;i++)
		{
			exs.submit(new Runner(user, session));
			/*session.insert("User.insert", user);
			session.commit();
			Integer maxId= (Integer)session.selectOne("User.maxId");
			System.out.println("maxId: "+maxId);
			System.out.println("user: "+(UserTEO)session.selectOne("User.getById",maxId));
			System.out.println("record inserted successfully");*/
		}
		
		exs.shutdown();
		//session.close();

	}
}
class Runner implements Runnable
{

	UserTEO user;
	SqlSession session;
	
	Runner(UserTEO user, SqlSession session)
	{
		this.user= user;
		this.session= session;
	}
	
	@Override
	public void run() {
		//Insert student data      
		insert();
		Integer maxId= (Integer)session.selectOne("User.maxId");
		System.out.println("maxId: "+maxId);
		System.out.println("user: "+(UserTEO)session.selectOne("User.getById",maxId));
		System.out.println("record inserted successfully");
	}
	
	private synchronized void insert()
	{
		System.out.println("curT: "+Thread.currentThread().getName());
		session.insert("User.insert", user);
		System.out.println("inserted ");
		session.commit();
		System.out.println("commited ");
	}
	
}
