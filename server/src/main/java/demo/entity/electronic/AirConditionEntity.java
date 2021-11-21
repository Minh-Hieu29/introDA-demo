package demo.entity.electronic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Entity
@Table(name = "air_condition")
public class AirConditionEntity extends ElectronicEntity {
    @Column
    private String wattage;

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }
}
