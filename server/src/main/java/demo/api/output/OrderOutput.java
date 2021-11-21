package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.order.CartDTO;
import demo.dto.order.CashDTO;
import demo.dto.order.CheckDTO;
import demo.dto.order.CreditDTO;
import demo.dto.order.OrderDTO;
import demo.dto.order.PaymentDTO;
import demo.dto.order.ShipmentDTO;

public class OrderOutput {
	private int page;
	private int totalPage;
	private List<OrderDTO> listOrder = new ArrayList<>();
	private List<CartDTO> listCart = new ArrayList<>();
	private List<CashDTO> listCash = new ArrayList<>();
	private List<CheckDTO> listCheck = new ArrayList<>();
	private List<CreditDTO> listCredit = new ArrayList<>();
	private List<PaymentDTO> listPayment = new ArrayList<>();
	private List<ShipmentDTO> listShipment = new ArrayList<>();
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
	public List<OrderDTO> getListOrder() {
		return listOrder;
	}
	public void setListOrder(List<OrderDTO> listOrder) {
		this.listOrder = listOrder;
	}
	public List<CartDTO> getListCart() {
		return listCart;
	}
	public void setListCart(List<CartDTO> listCart) {
		this.listCart = listCart;
	}
	public List<PaymentDTO> getListPayment() {
		return listPayment;
	}
	public void setListPayment(List<PaymentDTO> listPayment) {
		this.listPayment = listPayment;
	}
	public List<ShipmentDTO> getListShipment() {
		return listShipment;
	}
	public void setListShipment(List<ShipmentDTO> listShipment) {
		this.listShipment = listShipment;
	}
	public List<CashDTO> getListCash() {
		return listCash;
	}
	public void setListCash(List<CashDTO> listCash) {
		this.listCash = listCash;
	}
	public List<CheckDTO> getListCheck() {
		return listCheck;
	}
	public void setListCheck(List<CheckDTO> listCheck) {
		this.listCheck = listCheck;
	}
	public List<CreditDTO> getListCredit() {
		return listCredit;
	}
	public void setListCredit(List<CreditDTO> listCredit) {
		this.listCredit = listCredit;
	}
	
	
	
}
