package demo.dto.electronic;

/**
 * Created by Junkie on 21/11/2021.
 **/
public class ElectronicItemDTO {
    private Long id;
    private String name;
    private float price;
    private String discount;
    private String barCode;
    private String electronicId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getElectronicId() {
        return electronicId;
    }

    public void setElectronicId(String electronicId) {
        this.electronicId = electronicId;
    }
}
