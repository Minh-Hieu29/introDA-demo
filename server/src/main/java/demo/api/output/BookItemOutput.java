package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.book.BookItemDTO;

public class BookItemOutput {
	private int page;
	private int totalPage;
	private List<BookItemDTO> listBookItem = new ArrayList<>();
	
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

	public List<BookItemDTO> getListBookItem() {
		return listBookItem;
	}

	public void setListBookItem(List<BookItemDTO> listBookItem) {
		this.listBookItem = listBookItem;
	}
}
