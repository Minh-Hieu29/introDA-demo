package demo.entity.shoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boots")
public class BootsEntity extends ShoesEntity{
	
	@Column(name = "model")
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	
	
}
