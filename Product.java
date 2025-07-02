package a3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	

	@ManyToMany(mappedBy = "products")
	private List<Order> orders;
	
	public Product() {
		
	}
	
	public Product(String n) {
		this.name = n;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> o) {
		this.orders = o;
	}
	
	public void addOrders(Order o) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
	    if (!orders.contains(o)) {
	    	orders.add(o);
	    	o.addProduct(this); // Mutual link only if not already added
	    }		
		
	}
}