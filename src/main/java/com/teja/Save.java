package com.teja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.entity.Cart;
import com.teja.entity.User;

public class Save 
{
    public static void main( String[] args )
    {
    	//Creating Session Factory
    	SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Cart.class)
				.buildSessionFactory();
    	
    	//Creating a Current Session
    	Session session = factory.getCurrentSession();
    	
    	session.beginTransaction();
    	
    	User user = new User("Teja","yerraguntlatja4@gmail.com");
    	Cart cart = new Cart();
    	cart.setTotalPrice(0);
    	user.setCart(cart);
    	session.save(user);
    	
    	//Commiting Current Session
//    	session.getTransaction().commit();
    	// Closing Current Session
    	session.close();
    }
}
