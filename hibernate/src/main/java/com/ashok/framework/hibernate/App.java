package com.ashok.framework.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ashok.framework.hibernate.model.Course;
import com.ashok.framework.hibernate.model.Name;
import com.ashok.framework.hibernate.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration config= new Configuration().configure(App.class.getResource("/hibernate.cfg.xml"))
        		.addAnnotatedClass(Student.class)
        		.addAnnotatedClass(Course.class);
        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Course course= new Course();
        course.setCourseId(1);
        course.setCourseName("MCA");
        session.save(course);
        
        Name name= new Name();
        name.setFirstName("Ashok");
        name.setMiddleName("Kumar");
        name.setLastName("Dhulipalla");
        
        Student student= new Student();
        student.setRollNumber(101);
        student.setName(name);
        student.setGender("Male");
        student.setCourse(course);
        Transaction txn= session.beginTransaction();
        
        session.save(student);
        
        txn.commit();
        
        sessionFactory.close();
    }
}
