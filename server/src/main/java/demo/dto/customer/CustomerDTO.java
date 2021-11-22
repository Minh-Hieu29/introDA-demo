package demo.dto.customer;

import java.util.Date;
import java.util.List;

import demo.dto.AbstractDTO;

public class CustomerDTO extends AbstractDTO<CustomerDTO>{

	private String phone;
	private String sex;
	private Date dob;
	private long accountId;
	private long fullNameId;
	private List<Long> addressId;
	
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
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getFullNameId() {
		return fullNameId;
	}
	public void setFullNameId(long fullNameId) {
		this.fullNameId = fullNameId;
	}
	public List<Long> getAddressId() {
		return addressId;
	}
	public void setAddressId(List<Long> addressId) {
		this.addressId = addressId;
	}
	
	
}
