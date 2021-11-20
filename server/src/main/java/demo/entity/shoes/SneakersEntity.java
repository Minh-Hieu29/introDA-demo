package demo.entity.shoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sneakers")
public class SneakersEntity extends ShoesEntity{
	
	@Column(name = "style")
	private String style;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
