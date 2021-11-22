package demo.entity.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "clothes_item")
public class ClothesItemEntity extends BaseEntity{

	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;
	
	@OneToOne
    @JoinColumn(name = "clothes_id")
	private ClothesEntity clothes;

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

	public ClothesEntity getClothes() {
		return clothes;
	}

	public void setClothes(ClothesEntity clothes) {
		this.clothes = clothes;
	}
	
	
}
