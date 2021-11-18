package demo.dto.book;

public class AuthorDTO extends AbstractDTO<AuthorDTO>{

	private String name;
	private String biography;
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
}
