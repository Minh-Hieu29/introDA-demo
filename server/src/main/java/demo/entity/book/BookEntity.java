package demo.entity.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity{
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "pages")
	private int pages;
	
	@Column(name = "language")
	private String language;

	@Column(name = "image_url")
	private String imageUrl;
	
	@OneToOne(mappedBy = "books",
			fetch = FetchType.LAZY)
	private BookItemEntity bookItems;
	
	@ManyToOne
	@JoinColumn(name = "publiser_id")
	private PublisherEntity publisher;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@ManyToMany
	@JoinTable(name = "book_author",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<AuthorEntity> authors = new ArrayList<>();
	
	
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
	
	
	public BookItemEntity getBookItems() {
		return bookItems;
	}
	public void setBookItems(BookItemEntity bookItems) {
		this.bookItems = bookItems;
	}
	public List<AuthorEntity> getAuthors() {
		return authors;
	}
	public void setAuthors(AuthorEntity authorEntity) {
		this.authors = (List<AuthorEntity>) authorEntity;
	}
	public PublisherEntity getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherEntity publisher) {
		this.publisher = publisher;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
