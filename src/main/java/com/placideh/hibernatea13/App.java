package com.placideh.hibernatea13;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * WE ARE USING 
 * GET AND LOAD
 * Load : fires the query when it is execute 
 * Get: always fires the query even though it is not execute
 * thet also have the difference in the exception 
 * ex. if we pass into that method invalid input
 * get: will throw a nullPointer exception 
 * load: will throw an OjbectNotfoundException 
 * 
 * normally we use load if you want to use the object as the 
 * fake object so that it won't going to run 
 * sometimes it is called a proxy object
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con =new Configuration().configure().addAnnotatedClass(Laptop.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session =sf.openSession();
    	session.beginTransaction();
    	
    	Laptop lap=session.load(Laptop.class, 6);
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(lap);
    	session.close();
    }
}
