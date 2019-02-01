package com.ashok.util.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		return buildSessionFactory(null);
	}
	
	private static SessionFactory buildSessionFactory(String fileName) {
		try {
			if(fileName == null)
				fileName= "hibernate.cfg.xml";
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration= configuration.configure(fileName);
			System.out.println("hibernate config success");
			return configuration.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session  openSession() {
		return sessionFactory.openSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		sessionFactory.close();
	}

	public static String columnName(String PojoProp)
	{
		String res="";
		int i=1;
		StringBuilder sb= new StringBuilder(PojoProp);
		res+= sb.charAt(0);
		for(i=2;i < sb.length();i++)
		{
			char c= sb.charAt(i-1);
			if(Character.isLowerCase(c) && Character.isUpperCase(sb.charAt(i)))
				res+= c+" ";
			else if(Character.isUpperCase(c) && Character.isLowerCase(sb.charAt(i)))
			{
				res= res.trim();
				res+= " "+Character.toLowerCase(c);
			}
			else
				res+= c;
		}
		res+= sb.charAt(i-1);
		return res.replace(" ", "_").toLowerCase();
	}
	
	private static Object selectOne(Session session,String tableName,String columnName, Object columnValue)
	{
		
		List<Object> list= select(session, tableName, columnName, columnValue);
		if(list != null && !list.isEmpty())
			return list.get(0);
		else
			return null;
	}
	
	private static List<Object> select(Session session,String tableName,String columnName, Object columnValue)
	{
		Query query = session.createQuery("from "+tableName+" where "+columnName+"= :"+columnName);
		query.setParameter(columnName, columnValue);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T selectOne(Session session,Class<T> pojoClass,String columnName, Object columnValue)
	{
		return (T) selectOne(session, pojoClass.getName(), columnName, columnValue);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> select(Session session,Class<T> pojoClass,String columnName, Object columnValue)
	{
		return (List<T>) select(session, pojoClass.getName(), columnName, columnValue);
	}

}
