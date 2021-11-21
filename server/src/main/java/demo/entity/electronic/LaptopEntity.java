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
    @Column
    private String weight;

    @Column(name = "windows_version")
    private String windowsVersion;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWindowsVersion() {
        return windowsVersion;
    }

    public void setWindowsVersion(String windowsVersion) {
        this.windowsVersion = windowsVersion;
    }
}
