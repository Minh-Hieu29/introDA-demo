package demo.entity.shoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "shoesitem")
public class ShoesItemEntity extends BaseEntity{
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoes_id")
	private ShoesEntity shoess;

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

	public ShoesEntity getShoess() {
		return shoess;
	}

	public void setShoess(ShoesEntity shoess) {
		this.shoess = shoess;
	}
	
	
}
