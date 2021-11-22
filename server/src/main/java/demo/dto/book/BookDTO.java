package demo.dto.book;

import java.util.ArrayList;
import java.util.List;

import demo.dto.AbstractDTO;


public class BookDTO extends AbstractDTO<BookDTO>{
	
	private String title;
	private String summary;
	private int pages;
	private String language;
	private long categoryID;
	private long publisherID;
//	private List<Long> authorID;
	private String imageUrl;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public long getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(long publisherID) {
		this.publisherID = publisherID;
	}
//	public List<Long> getAuthorID() {
//		return authorID;
//	}
//	public void setAuthorID(List<Long> authorID) {
//		this.authorID = authorID;
//	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
