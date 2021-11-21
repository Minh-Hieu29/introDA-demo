package demo.entity.electronic;

import demo.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Entity
@Table(name = "electronic")
public class ElectronicEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "screen_size")
    private float screenSize;

    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "electronicEntity",
                fetch = FetchType.LAZY)
    private ElectronicItemEntity electronicItemEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ElectronicItemEntity getElectronicItemEntity() {
        return electronicItemEntity;
    }

    public void setElectronicItemEntity(ElectronicItemEntity electronicItemEntity) {
        this.electronicItemEntity = electronicItemEntity;
    }
}
