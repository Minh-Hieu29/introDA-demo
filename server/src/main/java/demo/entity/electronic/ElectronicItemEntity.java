package demo.entity.electronic;

import demo.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Entity
@Table(name = "electronic_item")
public class ElectronicItemEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private float price;

    @Column
    private String discount;

    @Column(name = "bar_code")
    private String barCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electronic_id")
    private ElectronicEntity electronicEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public ElectronicEntity getElectronicEntity() {
        return electronicEntity;
    }

    public void setElectronicEntity(ElectronicEntity electronicEntity) {
        this.electronicEntity = electronicEntity;
    }
}
