package demo.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer_new")
public class CustomerNewEntity extends CustomerEntity{

	@Column(name = "note")
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	} 
	
	
}
