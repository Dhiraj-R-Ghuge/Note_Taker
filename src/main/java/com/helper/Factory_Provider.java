package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory_Provider {
	public static SessionFactory factory;  
	public  static SessionFactory getFactory() {//for implimentation of   session factory
		
		if(factory==null) {
			factory=new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	public void closeFactory() {
		
		if(factory.isOpen()) {
			factory.close();
		}
	}

}
