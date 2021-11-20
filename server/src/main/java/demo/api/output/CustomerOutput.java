package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.customer.CustomerDTO;

public class CustomerOutput {

	private int page;
	private int totalPage;
	private List<CustomerDTO> listCustomer = new ArrayList<>();
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
	public List<CustomerDTO> getListCustomer() {
		return listCustomer;
	}
	public void setListCustomer(List<CustomerDTO> listCustomer) {
		this.listCustomer = listCustomer;
	}
	
	
}
