package demo.entity.electronic;

import demo.entity.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "electronic")
public class ElectronicEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "model")
    private String model;
    
    @Column(name = "origin")
    private String origin;
    
    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "ram")
    private String ram;

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

    

    public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
    
    
}
