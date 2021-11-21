package demo.entity.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id  //primary key + not null
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "dob")
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name = "fullname_lastname")
	private FullNameEntity fullName;
	
	@OneToOne
    @JoinColumn(name = "account_username")
	private AccountEntity account;
	
	@OneToMany(mappedBy = "customer")
	private List<AddressEntity> address = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public FullNameEntity getFullName() {
		return fullName;
	}

	public void setFullName(FullNameEntity fullName) {
		this.fullName = fullName;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEntity> address) {
		this.address = address;
	}
	
	
}
