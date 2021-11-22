package demo.dto.clothes;

import demo.dto.AbstractDTO;

public class ClothesItemDTO extends AbstractDTO{

	private float price;
	private float discount;
	private long clothesId;
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
	
	public long getClothesId() {
		return clothesId;
	}
	public void setClothesId(long clothesId) {
		this.clothesId = clothesId;
	}
	
	
}
