package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.clothes.ClothesItemDTO;
import demo.dto.clothes.DressDTO;
import demo.dto.clothes.ShirtDTO;
import demo.dto.clothes.TrousersDTO;

public class ClothesOutput extends PageOutput{

	private List<DressDTO> listDress = new ArrayList<>();
	private List<ShirtDTO> listShirt = new ArrayList<>();
	private List<TrousersDTO> listTrousers = new ArrayList<>();
	private List<ClothesItemDTO> listClothesItem = new ArrayList<>();
	public List<DressDTO> getListDress() {
		return listDress;
	}
	public void setListDress(List<DressDTO> listDress) {
		this.listDress = listDress;
	}
	public List<ShirtDTO> getListShirt() {
		return listShirt;
	}
	public void setListShirt(List<ShirtDTO> listShirt) {
		this.listShirt = listShirt;
	}
	public List<TrousersDTO> getListTrousers() {
		return listTrousers;
	}
	public void setListTrousers(List<TrousersDTO> listTrousers) {
		this.listTrousers = listTrousers;
	}
	public List<ClothesItemDTO> getListClothesItem() {
		return listClothesItem;
	}
	public void setListClothesItem(List<ClothesItemDTO> listClothesItem) {
		this.listClothesItem = listClothesItem;
	}
	
	
}
