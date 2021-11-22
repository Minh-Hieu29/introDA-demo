package demo.entity.electronic;

import demo.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Entity
@Table(name = "electronic_item")
public class ElectronicItemEntity extends BaseEntity {

    @Column(name = "price")
    private float price;

    @Column(name = "discount")
    private float discount;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electronic_id")
    private ElectronicEntity electronicEntity;


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


	public ElectronicEntity getElectronicEntity() {
		return electronicEntity;
	}


	public void setElectronicEntity(ElectronicEntity electronicEntity) {
		this.electronicEntity = electronicEntity;
	}

    
}
