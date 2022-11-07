package com.teja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.entity.Cart;
import com.teja.entity.User;

public class Delete {

	public static void main(String[] args) {
		//Creating Session Factory
    	SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
    	
    	//Creating a Current Session
    	Session session = factory.getCurrentSession();
    	
    	session.beginTransaction();
    	
    	User user = session.get(User.class,1);
    	
    	session.delete(user);
    	
    	//Commiting Current Session
    	session.getTransaction().commit();
    	// Closing Current Session
    	session.close();

	}

}
