package demo.api.output;

import java.util.ArrayList;
import java.util.List;

import demo.dto.book.AuthorDTO;
import demo.dto.book.BookDTO;
import demo.dto.book.CategoryDTO;
import demo.dto.book.PublisherDTO;

public class BookOutput {
	private int page;
	private int totalPage;
	private List<BookDTO> listResult = new ArrayList<>();
	private List<CategoryDTO> listCategory = new ArrayList<>();
	private List<PublisherDTO> listPublisher = new ArrayList<>();
	private List<AuthorDTO> listAuthor = new ArrayList<>();
	
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
	public List<BookDTO> getListResult() {
		return listResult;
	}
	public void setListResult(List<BookDTO> listResult) {
		this.listResult = listResult;
	}
	public List<CategoryDTO> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<CategoryDTO> listCategory) {
		this.listCategory = listCategory;
	}
	public List<PublisherDTO> getListPublisher() {
		return listPublisher;
	}
	public void setListPublisher(List<PublisherDTO> listPublisher) {
		this.listPublisher = listPublisher;
	}
	public List<AuthorDTO> getListAuthor() {
		return listAuthor;
	}
	public void setListAuthor(List<AuthorDTO> listAuthor) {
		this.listAuthor = listAuthor;
	}
	
	
}
