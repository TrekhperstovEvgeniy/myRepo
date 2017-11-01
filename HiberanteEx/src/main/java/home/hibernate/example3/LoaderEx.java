package home.hibernate.example3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoaderEx {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("ex3/hibernate.cfg.xml").buildSessionFactory();		

		Transaction trxn;
		Session session;

		// Create
		session = sessionFactory.openSession();
		trxn = session.beginTransaction();
		
		EntityEmployee employeeCreate = new EntityEmployee();
		employeeCreate.setName("Jack");
		employeeCreate.setAge(21);
		session.save(employeeCreate);
		Integer generatedId = employeeCreate.getId();
		trxn.commit();
		session.close();
		// end insert into
		
		// Read
		session = sessionFactory.openSession();
		EntityEmployee employeeRead = session.get(EntityEmployee.class, generatedId);
		System.out.println(employeeRead);
		session.close();
		// end read.
		
		// Update
		session = sessionFactory.openSession();
		trxn = session.beginTransaction();
		EntityEmployee employeeUpdate = employeeRead;
		employeeUpdate.setName("Tad");
		employeeUpdate.setAge(99);
		session.update(employeeUpdate);
		trxn.commit();
		session.close();
		// end update
		
		// Delete
		session = sessionFactory.openSession();
		trxn = session.beginTransaction();
		EntityEmployee employeeDelete = employeeUpdate;
		session.delete(employeeDelete);
		trxn.commit();
		session.close();
		// end delelte
		
		sessionFactory.close();
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
