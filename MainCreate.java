package a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jdbc.ConnectionFactory;

public class MainCreate{
	public static void main(String[] args) {
		String type = "hibernate";
		
		if (type.equals("jdbc")) {
		
			try {
				
				Connection conection = ConnectionFactory.getConnection();
				
				conection.setAutoCommit(false);
				
				Customer customer = new Customer("Me", "8 S University Dr, Pomona, CA");
				
				Professor prof = new Professor("bldg 8", "CS", 1);
				
				customer.setProf(prof);
				prof.setCustomer(customer);
				
				PreparedStatement stmt = conection.prepareStatement("INSERT INTO professor(office, "
						+ "area " + "id) VALUES(?,?,?)");		
				
				stmt.setString(1, prof.getOfficeNumber());
				stmt.setString(2, prof.getResearchArea());	
				stmt.setInt(3, prof.getId());	
				
				stmt.executeUpdate();
				
				stmt = conection.prepareStatement("SELECT * FROM Professor order by id desc");
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					prof.setId(rs.getInt("id"));
			    }				
				
				stmt = conection.prepareStatement("INSERT INTO Customer(name,"
						+ "address, professor_id) VALUES(?,?,?)");		
				
				stmt.setString(1, customer.getName());
				stmt.setString(2, customer.getAddress());	
				stmt.setInt(3, prof.getId());
				
				stmt.executeUpdate();
				
				conection.commit();
				
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
				

				Customer tempcustomer = new Customer("Me", "8 S University Dr, Pomona, CA");
				
				Professor tempprof = new Professor("bldg 8", "CS", 1);
				
				tempcustomer.setProf(tempprof);
				
				tempprof.setCustomer(tempcustomer);
				
				
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
