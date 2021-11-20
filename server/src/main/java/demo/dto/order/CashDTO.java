package demo.dto.order;

public class CashDTO extends PaymentDTO{
	private float cashTenderd;

	public float getCashTenderd() {
		return cashTenderd;
	}

	public void setCashTenderd(float cashTenderd) {
		this.cashTenderd = cashTenderd;
	}
}
