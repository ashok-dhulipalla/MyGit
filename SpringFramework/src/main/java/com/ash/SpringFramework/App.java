package com.ash.SpringFramework;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Resource resource= new ClassPathResource("applicationContext.xml");  
        //BeanFactory factory=new XmlBeanFactory(resource);  
        
        ApplicationContext context =   
        	    new ClassPathXmlApplicationContext("applicationContext.xml"); 
          
        Student student=(Student)context.getBean("studentbean");
        student.displayInfo();
        //Student student=(Student)factory.getBean("studentbean");  
        //student.displayInfo(); 
    }
}
