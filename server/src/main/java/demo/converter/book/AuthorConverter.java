package demo.converter.book;

import org.springframework.stereotype.Component;

import demo.dto.book.AuthorDTO;
import demo.entity.book.AuthorEntity;

@Component
public class AuthorConverter {

	public AuthorEntity toEntity(AuthorDTO dto) {
		AuthorEntity entity = new AuthorEntity();
		entity.setName(dto.getName());
		entity.setBiography(dto.getBiography());
		return entity;
	}
	
	public AuthorDTO toDTO(AuthorEntity entity) {
		AuthorDTO dto = new AuthorDTO();
		dto.setName(entity.getName());
		dto.setBiography(entity.getBiography());
		return dto;
	}
	
	public AuthorEntity toEntity(AuthorDTO dto, AuthorEntity entity) {
		entity.setName(dto.getName());
		entity.setBiography(dto.getBiography());
		return entity;
	}
}
