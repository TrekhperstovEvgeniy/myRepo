package home.hibernate.example2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoaderEx {

	//just run Hibernate application with annotations class.
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("ex2/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new EntityEmployee());
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();

	}

}
