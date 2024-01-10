package com.hibernate.hibernate.level2.Level_2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
	public static void main( String[] args )
	{

		//		Person p=new Person();
		//		p.setpId(1);
		//		p.setpName("Hinata");
		//		p.setpAge(23);
		//
		//		Person p1=new Person();
		//		p1.setpId(2);
		//		p1.setpName("manju");
		//		p1.setpAge(22);
		//
		//		Person p2=new Person();
		//		p2.setpId(3);
		//		p2.setpName("bwobwo");
		//		p2.setpAge(5);

		Configuration cfg=new Configuration().configure().addAnnotatedClass(Person.class);
		SessionFactory sf=cfg.buildSessionFactory();

		Session session1=sf.openSession();
		Transaction trans1=session1.beginTransaction();

		//		session1.save(p);
		//		session1.save(p1);
		//		session1.save(p2);

		System.out.println("----------------------------------------------------------");

		// hitting the data base and getting the data by using session 1

		Person personA=session1.load(Person.class, 1);
		System.out.println(personA);

		// hitting the data base and getting the data by using session 1

		Person personB=session1.load(Person.class, 2);
		System.out.println(personB);

		System.out.println("----------------------------------------------------------");

		Session session2=sf.openSession();
		Transaction trans2=session2.beginTransaction();

		// not hitting the database 
		// getting information form the level-2, that we already got through the session1 object.
		
		Person person1=session2.load(Person.class, 1);
		System.out.println(person1);
		
		
		Person person2=session2.load(Person.class, 2);
		System.out.println(person2);
		
		Person person3=session2.load(Person.class, 3);
		System.out.println(person3);

		System.out.println("----------------------------------------------------------");
		
		
		
		trans1.commit();
		session1.close();

		trans2.commit();
		session2.close();


		//		List<Object> lists=new ArrayList<Object>();
		//		lists.add(p2);
		//		lists.add(p1);
		//		lists.add(p2);
		//		
		//		for(Object li:lists) 
		//		{
		//			session.save(li);
		//		}


	}
}
