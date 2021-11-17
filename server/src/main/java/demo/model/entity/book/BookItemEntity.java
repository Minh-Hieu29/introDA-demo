package demo.model.entity.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_item")
public class BookItemEntity extends BaseEntity{

	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
	private BookEntity books;

	

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public BookEntity getBooks() {
		return books;
	}

	public void setBooks(BookEntity books) {
		this.books = books;
	}
	
	
}
