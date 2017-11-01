package home.hibernate.example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoaderEx {

	//just run Hibernate. Use XML mapping
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("ex1/hibernate.cfg.xml").buildSessionFactory();
		
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(new EntityEmployee());
//		session.getTransaction().commit();
//		session.close();

		sessionFactory.close();
		
	}

}
