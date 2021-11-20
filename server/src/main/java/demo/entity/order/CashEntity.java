package demo.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cash")
public class CashEntity extends PaymentEntity{

	@Column(name = "cash_tendered")
	private float cashTendered;

	public float getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(float cashTendered) {
		this.cashTendered = cashTendered;
	}
	
	
}
