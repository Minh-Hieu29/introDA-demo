package demo.dto.customer;

import java.util.Date;

public class CustomerDTO {

	private long id;
	private String phone;
	private String sex;
	private Date DOB;
	private String fullnameLastname;
	private String accountUsername;
	
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
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getFullnameLastname() {
		return fullnameLastname;
	}
	public void setFullnameLastname(String fullnameLastname) {
		this.fullnameLastname = fullnameLastname;
	}
	public String getAccountUsername() {
		return accountUsername;
	}
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	
}
