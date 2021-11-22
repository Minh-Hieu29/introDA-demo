package demo.dto.electronic;

import demo.dto.AbstractDTO;

/**
 * Created by Junkie on 21/11/2021.
 **/
public class ElectronicItemDTO extends AbstractDTO<ElectronicItemDTO>{
    private float price;
    private float discount;
    private long ElectronicId;
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
	public long getElectronicId() {
		return ElectronicId;
	}
	public void setElectronicId(long electronicId) {
		ElectronicId = electronicId;
	}

    
}
