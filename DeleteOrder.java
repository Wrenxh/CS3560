package a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jdbc.ConnectionFactory;

public class DeleteOrder {

	public static void main(String[] args) {
		
		String type = "hibernate";
		
if (type.equals("hibernate")) {
			
			SessionFactory factory = new Configuration().
						                 configure("hibernate.cfg.xml").
						                 addAnnotatedClass(Order.class).
						                 addAnnotatedClass(Product.class).			                 
						                 buildSessionFactory();
			
			Session session = factory.getCurrentSession();
			
			try {			
				
				session.beginTransaction();
				
				Order tempOrd = session.get(Order.class, 10);
				
				session.delete(tempOrd);
	
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				
				session.close();
				factory.close();
			}
				
		}	
		
		System.out.println("Done!");
	}
}