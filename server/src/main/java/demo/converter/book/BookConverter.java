package demo.converter.book;

import org.springframework.stereotype.Component;

import demo.dto.book.BookDTO;
import demo.entity.book.BookEntity;


@Component
public class BookConverter {
	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setIsbn(dto.getIsbn());
		entity.setTitle(dto.getTitle());
		entity.setSummary(dto.getSummary());
		entity.setPages(dto.getPages());
		entity.setLanguage(dto.getLanguage());
		return entity;
	}
	
	public BookDTO toDTO(BookEntity entity) {
		BookDTO dto = new BookDTO();
		if(entity.getId() != 0) {
			dto.setId(entity.getId());
		}
		dto.setIsbn(entity.getIsbn());
		dto.setTitle(entity.getTitle());
		dto.setSummary(entity.getSummary());
		dto.setPages(entity.getPages());
		dto.setLanguage(entity.getLanguage());
		return dto;
	}
	
	public BookEntity toEntity(BookDTO dto, BookEntity entity) {
		entity.setIsbn(dto.getIsbn());
		entity.setTitle(dto.getTitle());
		entity.setSummary(dto.getSummary());
		entity.setPages(dto.getPages());
		entity.setLanguage(dto.getLanguage());
		return entity;
	}
}
