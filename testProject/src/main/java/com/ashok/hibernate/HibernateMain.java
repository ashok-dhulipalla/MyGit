package com.ashok.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateMain {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString;
		Query query;
		session.beginTransaction();
		try
		{
			//create a record
			User user = new User();
			user.setUserId(7);
			user.setUsername("Mukesh");
			user.setCreatedBy("Google");
			user.setCreatedDate(new Date());
			session.save(user);

			//update record
			queryString = "from User where USER_ID = :id";
			query = session.createQuery(queryString);
			query.setInteger("id", 6);
			User empupdate = (User) query.uniqueResult();
			empupdate.setUsername("Ashok kumar dhulipalla");
			session.update(empupdate);

			//retrieve records
			List employee = session.createQuery("from User").list();
			for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
				User employee1 = (User) iterator.next();
				System.out.println(employee1.getUserId() + "  "
						+ employee1.getUsername() + "  " + employee1.getCreatedBy()
						+ "   " + employee1.getCreatedDate());
			}

			//session.delete(user);
			queryString = "from User where userId = :id";
			query = session.createQuery(queryString);
			query.setInteger("id", 1);
			User empdel = (User) query.uniqueResult();
			session.delete(empdel);


			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println("------Exception------\n"+e.toString());
		}
		finally {
			HibernateUtil.shutdown();
			System.out.println("------finally--------");
		}


	}

}
