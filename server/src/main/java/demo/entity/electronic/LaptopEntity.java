package demo.entity.electronic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Entity
@Table(name = "laptop")
public class LaptopEntity extends ElectronicEntity {
    @Column(name = "card")
    private String card;

    @Column(name = "cpu")
    private String cpu;

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
}
