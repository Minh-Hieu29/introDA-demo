package demo.dto.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorDTO<T> {

	private List<T> id = new ArrayList<>();
	private Date createrDate;
	private Date modifiedDate;
	public List<T> getId() {
		return id;
	}
	public void setId(List<T> id) {
		this.id = id;
	}
	public Date getCreaterDate() {
		return createrDate;
	}
	public void setCreaterDate(Date createrDate) {
		this.createrDate = createrDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
