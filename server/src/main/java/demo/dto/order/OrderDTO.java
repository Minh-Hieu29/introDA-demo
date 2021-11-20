package demo.dto.order;

import java.util.Date;

public class OrderDTO {

	private long id;
	private Date dateCreate;
	private String status;
	private int cartQuantity;
	private String shipmentName;
	private String paymentAmount;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getShipmentName() {
		return shipmentName;
	}
	public void setShipmentName(String shipmentName) {
		this.shipmentName = shipmentName;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
}
