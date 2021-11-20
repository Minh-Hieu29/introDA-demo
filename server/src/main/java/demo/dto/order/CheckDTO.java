package demo.dto.order;

public class CheckDTO extends PaymentDTO{

	private String name;
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
