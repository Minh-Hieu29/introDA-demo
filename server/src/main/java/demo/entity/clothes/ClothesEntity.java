package demo.entity.clothes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "clothes")
public class ClothesEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@OneToOne(mappedBy = "clothes")
	private ClothesItemEntity clothesItem;

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public ClothesItemEntity getClothesItem() {
		return clothesItem;
	}

	public void setClothesItem(ClothesItemEntity clothesItem) {
		this.clothesItem = clothesItem;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
