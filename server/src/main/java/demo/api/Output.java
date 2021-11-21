package demo.api;

import java.util.ArrayList;
import java.util.List;

import demo.dto.electronic.AirConditionDTO;
import demo.dto.electronic.ElectronicItemDTO;
import demo.dto.electronic.LaptopDTO;
import demo.dto.electronic.MobilePhoneDTO;
import demo.dto.shoes.BootsDTO;
import demo.dto.shoes.ShoesDTO;
import demo.dto.shoes.ShoesItemDTO;

public class Output {
	private int page;
	private int totalPage;
	private List<BootsDTO> listBoots = new ArrayList<>();
	private List<ShoesItemDTO> listShoesItem = new ArrayList<>();
	private List<LaptopDTO> listLaptop = new ArrayList<>();
	private List<ElectronicItemDTO> listElectronicItem = new ArrayList<>();
	private List<MobilePhoneDTO> listMobilePhone = new ArrayList<>();
	private List<AirConditionDTO> listAirCondition = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<BootsDTO> getListBoots() {
		return listBoots;
	}
	public void setListBoots(List<BootsDTO> listBoots) {
		this.listBoots = listBoots;
	}
	public List<ShoesItemDTO> getListShoesItem() {
		return listShoesItem;
	}
	public void setListShoesItem(List<ShoesItemDTO> listShoesItem) {
		this.listShoesItem = listShoesItem;
	}

	public List<ElectronicItemDTO> getListElectronicItem() {
		return listElectronicItem;
	}
	public void setListElectronicItem(List<ElectronicItemDTO> listElectronicItem) {
		this.listElectronicItem = listElectronicItem;
	}

	public List<LaptopDTO> getListLaptop() {
		return listLaptop;
	}

	public void setListLaptop(List<LaptopDTO> listLaptop) {
		this.listLaptop = listLaptop;
	}

	public List<MobilePhoneDTO> getListMobilePhone() {
		return listMobilePhone;
	}

	public void setListMobilePhone(List<MobilePhoneDTO> listMobilePhone) {
		this.listMobilePhone = listMobilePhone;
	}

	public List<AirConditionDTO> getListAirCondition() {
		return listAirCondition;
	}

	public void setListAirCondition(List<AirConditionDTO> listAirCondition) {
		this.listAirCondition = listAirCondition;
	}
}
