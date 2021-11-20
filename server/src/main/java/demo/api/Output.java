package demo.api;

import java.util.ArrayList;
import java.util.List;

import demo.dto.shoes.BootsDTO;
import demo.dto.shoes.ShoesDTO;
import demo.dto.shoes.ShoesItemDTO;

public class Output {
	private int page;
	private int totalPage;
	private List<BootsDTO> listBoots = new ArrayList<>();
	private List<ShoesItemDTO> listShoesItem = new ArrayList<>();
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
	
	
}
