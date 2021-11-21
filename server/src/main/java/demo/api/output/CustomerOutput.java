package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.customer.CustomerDTO;
import demo.dto.customer.CustomerMemberDTO;
import demo.dto.customer.CustomerNewDTO;

public class CustomerOutput {

	private int page;
	private int totalPage;
	private List<CustomerNewDTO> listCustomerNew = new ArrayList<>();
	private List<CustomerMemberDTO> listCustomerMember =  new ArrayList<>();
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
	public List<CustomerNewDTO> getListCustomerNew() {
		return listCustomerNew;
	}
	public void setListCustomerNew(List<CustomerNewDTO> listCustomerNew) {
		this.listCustomerNew = listCustomerNew;
	}
	public List<CustomerMemberDTO> getListCustomerMember() {
		return listCustomerMember;
	}
	public void setListCustomerMember(List<CustomerMemberDTO> listCustomerMember) {
		this.listCustomerMember = listCustomerMember;
	}
	
	
	
}
