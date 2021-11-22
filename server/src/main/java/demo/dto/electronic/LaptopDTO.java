package demo.dto.electronic;

/**
 * Created by Junkie on 21/11/2021.
 **/
public class LaptopDTO extends ElectronicDTO {
    private String cpu;
    private String card;
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}

    
}
