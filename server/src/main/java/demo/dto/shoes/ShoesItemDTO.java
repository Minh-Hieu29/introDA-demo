package demo.dto.shoes;

public class ShoesItemDTO {
	private long ID;
	private float price;
	private float discount;
	private long shoesID;
	
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public long getShoesID() {
		return shoesID;
	}
	public void setShoesID(long shoesID) {
		this.shoesID = shoesID;
	}
	
	
	
	
}
