package demo.dto.electronic;

/**
 * Created by Junkie on 21/11/2021.
 **/
public class MobilePhoneDTO extends ElectronicDTO {
    private String weight;
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
