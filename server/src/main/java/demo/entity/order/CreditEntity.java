package demo.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit")
public class CreditEntity extends PaymentEntity{

	@Column(name = "number")
	private String number;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "date")
	private String date;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
