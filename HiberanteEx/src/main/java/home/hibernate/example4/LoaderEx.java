package home.hibernate.example4;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoaderEx {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("ex4/hibernate.cfg.xml").buildSessionFactory();
		sessionFactory.close();
		
	}

}
