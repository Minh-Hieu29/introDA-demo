package demo.entity.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import demo.entity.BaseEntity;

@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@Column(name = "biography")
	private String biography;
	
	@ManyToMany(mappedBy = "authors")
	private List<BookEntity> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
	
	
	
	
}
