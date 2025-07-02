package a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jdbc.ConnectionFactory;

public class CreateOrder{
	
	public static void main(String[] args) {
		
		String type = "hibernate";
		if (type.equals("hibernate")) {			

			SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Order.class)
										.addAnnotatedClass(Product.class)							
										.buildSessionFactory();
			
			Session session = factory.getCurrentSession();
			
			try {			
				
				session.beginTransaction();
							
				Order orders = session.get(Order.class, 11);		
				
				Product tp1 = new Product("RC Car");
				Product tp2 = new Product("Slotcar");
							
				orders.addProduct(tp1);
				orders.addProduct(tp2);
				
				session.save(tp1);
				session.save(tp2);
				
				session.getTransaction().commit();
				
			}
			finally {
				
				session.close();
				factory.close();
			}
			
		}	
		
		System.out.println("Done!");
		
	}
}