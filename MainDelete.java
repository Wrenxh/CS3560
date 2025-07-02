package a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jdbc.ConnectionFactory;

public class MainDelete {

	public static void main(String[] args) {
		
		String type = "hibernate";
		
		if (type.equals("jdbc")) {
			
			try {
				
				Connection conection = ConnectionFactory.getConnection();
				PreparedStatement stmt = conection.prepareStatement("SELECT * FROM instructor inner join "
						+ "instructor_detail on instructor.instructor_detail_id = instructor_detail.id where instructor.id=?");
				stmt.setInt(1, 5);
				
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					
					Customer customer = new Customer(rs.getString("Me"), rs.getString("8 S University Dr, Pomona, CA"));
					customer.setId(rs.getInt("id"));
					
					Professor prof = new Professor(rs.getString("bldg 8"), rs.getString("CS"), rs.getInt(1));
					
					customer.setProf(prof);
					prof.setCustomer(customer);
			        System.out.println(prof);
			        System.out.println(customer);
			        
					conection.setAutoCommit(false);
					
					stmt = conection.prepareStatement("Delete from customer WHERE id = ?");		
					
					stmt.setInt(1, customer.getId());	
					
					stmt.executeUpdate();

					stmt = conection.prepareStatement("Delete from professor WHERE id = ?");
					
					stmt.setInt(1, prof.getId());
					
					stmt.executeUpdate();
					
					conection.commit();
					//conection.rollback();
			        
			    }
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
    	} else if (type.equals("hibernate")) {
		
			SessionFactory factory = new Configuration().
					                 configure("hibernate.cfg.xml").
					                 addAnnotatedClass(Professor.class).
					                 addAnnotatedClass(Customer.class).
					                 buildSessionFactory();
			
			Session session = factory.getCurrentSession();
			
			try {
				
				session.beginTransaction();
				
				Customer customer = session.get(Customer.class, 6);
				Professor prof = session.get(Professor.class, 6);
				
				session.delete(customer);
				session.delete(prof);
				
				session.getTransaction().commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				factory.close();
			}
			
    	}	
		
		System.out.println("Done!");
		
	}
	
}
