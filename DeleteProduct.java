package a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jdbc.ConnectionFactory;

public class DeleteProduct {

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
					
				Product prod = session.get(Product.class, 25);
				
			    for (Order order: prod.getOrders()) {
			        order.getProducts().remove(prod);
			    }

				System.out.println("\nDeleting student: " + prod);
				session.delete(prod);
				
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {

				session.close();
				
				factory.close();
			}
			
		}
	}

}