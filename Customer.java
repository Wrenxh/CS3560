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
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	public Customer() {
		
	}
	
	public Customer(String Name, String addy) {
		this.Name = Name;
		this.address = addy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setName(String n) {
		this.Name = n;
	}
	
	public void setAddress(String n) {
		this.address = n;
	}
	
	public Professor getProf() {
		return professor;
	}
	
	public void setProf(Professor p) {
		professor = p;
	}
	
}
