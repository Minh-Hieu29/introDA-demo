package demo.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity{
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "city")
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "address_customer")
	private CustomerEntity customer;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	
}
