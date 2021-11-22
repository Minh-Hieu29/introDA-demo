package demo.entity.electronic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Entity
@Table(name = "mobile_phone")
public class MobilePhoneEntity extends ElectronicEntity {
    @Column(name = "chip")
    private String chip;

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

    
}
