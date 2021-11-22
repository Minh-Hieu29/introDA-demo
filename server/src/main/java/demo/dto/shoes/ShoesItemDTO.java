package demo.dto.shoes;

import demo.dto.AbstractDTO;

public class ShoesItemDTO extends AbstractDTO<ShoesItemDTO>{
	
	private float price;
	private float discount;
	private long shoesID;
	
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
