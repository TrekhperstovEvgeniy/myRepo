package home.hibernate.example5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.hibernate.example4.EntityCompany;
import home.hibernate.example4.EntityEmployee;
import home.hibernate.example4.EntityOrder;

public class LoaderEx {

	public static void main(String... args){
		
		SessionFactory sessionFactory = new Configuration().configure("ex4/hibernate.cfg.xml").buildSessionFactory();
		
		
		//Fill DB
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		EntityEmployee employee1 = new EntityEmployee();employee1.setName("Name2"); employee1.setAge(1); 
		EntityEmployee employee2 = new EntityEmployee();employee2.setName("Name2"); employee2.setAge(2); 
		EntityEmployee employee3 = new EntityEmployee();employee3.setName("Name3"); employee3.setAge(3); 
		EntityEmployee employee4 = new EntityEmployee();employee4.setName("Name4"); employee4.setAge(4);
		session.save(employee1); 
		session.save(employee2); 
		session.save(employee3); 
		session.save(employee4); 
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();	
		session.beginTransaction();
		EntityOrder order1 = new EntityOrder(); order1.setDescription("A");
		EntityOrder order2 = new EntityOrder(); order2.setDescription("B");
		EntityOrder order3 = new EntityOrder(); order3.setDescription("C");
		session.save(order1);
		session.save(order2);
		session.save(order3);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();	
		session.beginTransaction();
		EntityCompany company1 = new EntityCompany(); company1.setEmployee(Arrays.asList(employee1, employee2)); company1.setOrder(Arrays.asList(order1)); company1.setName("C1");
		EntityCompany company2 = new EntityCompany(); company2.setEmployee(Arrays.asList(employee3, employee4)); company2.setOrder(Arrays.asList(order2,order3)); company2.setName("C2");
		session.save(company1);
		session.save(company2);
		session.getTransaction().commit();
		session.close();
		
		
		session = sessionFactory.openSession();
		Query query = session.createQuery("from EntityEmployee");
		System.out.println("Execute HQL query 'from EntityEmployee'");
		List<EntityEmployee> list = (List<EntityEmployee>)query.list();
		session.close();
		System.out.println("Result:");
		
		for(Iterator<EntityEmployee> i = list.iterator(); i.hasNext(); ){
			System.out.println(i.next());
		}
		System.out.println("=======================================");
		
		session = sessionFactory.openSession();
		query = session.createQuery(""
				+ "from EntityEmployee "
				+ "where age>2");
		System.out.println("Execute HQL query 'from EntityEmployee where age >2'");
		list = (List<EntityEmployee>)query.list();
		session.close();
		System.out.println("Result:");
		
		for(Iterator<EntityEmployee> i = list.iterator(); i.hasNext(); ){
			System.out.println(i.next());
		}
		System.out.println("=======================================");
		
		session = sessionFactory.openSession();
		query = session.createQuery(""
				+ "select age "
				+ "from EntityEmployee "
				+ "where age>2");
		System.out.println("Execute HQL query 'select Employee.age from EntityEmployee as Employee where age>2'");
		list = (List<EntityEmployee>)query.list();
		session.close();
		System.out.println("Result:");
		
		for(Iterator<EntityEmployee> i = list.iterator(); i.hasNext(); ){
			System.out.println(i.next());
		}
		System.out.println("=======================================");
		
		session = sessionFactory.openSession();
		query = session.createQuery(""
				+ "select sum(Employee.age) "
				+ "from EntityEmployee as Employee "
				+ "group by Employee.name "
				+ "having Employee.name='Name2'");
		System.out.println("Execute HQL query 'select Employee.age from EntityEmployee as Employee where age>2'");
		list = (List<EntityEmployee>)query.list();
		session.close();
		System.out.println("Result:");
		
		for(Iterator<EntityEmployee> i = list.iterator(); i.hasNext(); ){
			System.out.println(i.next());
		}
		System.out.println("=======================================");
		
		
		
		
		
		sessionFactory.close();
	}
}
