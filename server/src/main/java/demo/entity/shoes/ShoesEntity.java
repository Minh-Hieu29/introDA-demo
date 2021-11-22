package demo.entity.shoes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "shoes")
public class ShoesEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "origin")
	private String origin;

	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "shoess",
            fetch = FetchType.LAZY)
	private ShoesItemEntity shoesItem;

	

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public ShoesItemEntity getShoesItem() {
		return shoesItem;
	}

	public void setShoesItem(ShoesItemEntity shoesItem) {
		this.shoesItem = shoesItem;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
