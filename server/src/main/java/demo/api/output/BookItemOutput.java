package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.book.BookDTO;
import demo.dto.book.BookItemDTO;

public class BookItemOutput {
	private int page;
	private int totalPage;
	private List<BookItemDTO> listResult = new ArrayList<>();
	private List<BookDTO> listResult1 = new ArrayList<>();
	
	public List<BookDTO> getListResult1() {
		return listResult1;
	}
	public void setListResult1(List<BookDTO> listResult1) {
		this.listResult1 = listResult1;
	}
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
	public List<BookItemDTO> getListResult() {
		return listResult;
	}
	public void setListResult(List<BookItemDTO> listResult) {
		this.listResult = listResult;
	}

}
