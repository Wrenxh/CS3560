package a3;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="customer_name")
	private String cusName;
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="order_detail",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private List<Product> products;
	
	public Order() {
		
	}
	
	public Order(String d, String n) {
		this.date = d;
		this.cusName = n;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setName(String n) {
		this.cusName = n;
	}
	
	public String getName() {
		return cusName;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setCourses(List<Product> p) {
		this.products = p;
	}
	
public void addProduct(Product p) {
		
		if (products == null) {
			products = new ArrayList<>();
		}
		
	    if (!products.contains(p)) {
	    	products.add(p);
	        p.addOrders(this); // Mutual link only if not already added
	    }		
		
	}	
}