package demo.dto.electronic;

/**
 * Created by Junkie on 21/11/2021.
 **/
public class LaptopDTO extends ElectronicDTO {
    private String weight;
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
