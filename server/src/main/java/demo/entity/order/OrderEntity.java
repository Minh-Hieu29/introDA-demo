package demo.entity.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{
	
	@Column(name = "date_create")
	private Date dateCreate;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id")
	private ShipmentEntity shipment;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
	private PaymentEntity payment;

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

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public ShipmentEntity getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentEntity shipment) {
		this.shipment = shipment;
	}

	public PaymentEntity getPayment() {
		return payment;
	}

	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}
	
	
 
}
