package demo.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "check")
public class CheckEntity extends PaymentEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "bank_id")
	private String bankID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	
	
}
