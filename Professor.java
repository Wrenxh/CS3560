package a3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Professor")
public class Professor{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="officeNumber")
	private String officeNumber;
	
	@Column(name="researchArea")
	private String researchArea;
	
	@Column(name="customerID")
	private int customerID;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
public Professor() {
		
	}
	
	public Professor(String office, String area, int ID) {
		this.officeNumber = office;
		this.researchArea = area;
		this.customerID = ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getOfficeNumber() {
		return officeNumber;
	}
	
	public void setOfficeNumber(String office) {
		this.officeNumber = office;
	}
	
	public String getResearchArea() {
		return researchArea;
	}
	
	public void setResearchArea(String area) {
		this.researchArea = area;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int ID) {
		this.customerID = ID;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer p) {
		customer = p;
	}
	
	
}