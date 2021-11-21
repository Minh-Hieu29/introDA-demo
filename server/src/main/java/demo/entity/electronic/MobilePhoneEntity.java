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
    @Column
    private String weight;

    @Column(name = "software_sersion")
    private String softwareVersion;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }
}
