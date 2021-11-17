package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.model.dto.book.*;

public class BookItemOutput {
	private int page;
	private int totalPage;
	private List<BookItemDTO> listResult = new ArrayList<>();
	
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
