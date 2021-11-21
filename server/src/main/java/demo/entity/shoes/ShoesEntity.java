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

	@Column(name = "size")
	private int size;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "model")
	private String model;

	@Column(name = "image_url")
	private String imageUrl;
	
	@OneToOne(mappedBy = "shoess",
            fetch = FetchType.LAZY)
	private ShoesItemEntity shoesItem;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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
}
