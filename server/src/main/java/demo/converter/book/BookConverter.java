package demo.converter.book;

import org.springframework.stereotype.Component;

import demo.dto.book.BookDTO;
import demo.entity.book.BookEntity;


@Component
public class BookConverter {
	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setSummary(dto.getSummary());
		entity.setPages(dto.getPages());
		entity.setLanguage(dto.getLanguage());
		entity.setImageUrl(dto.getImageUrl());
		return entity;
	}
	
	public BookDTO toDTO(BookEntity entity) {
		BookDTO dto = new BookDTO();
		if(entity.getId() != 0) {
			dto.setId(entity.getId());
		}
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setTitle(entity.getTitle());
		dto.setSummary(entity.getSummary());
		dto.setPages(entity.getPages());
		dto.setLanguage(entity.getLanguage());
		dto.setImageUrl(entity.getImageUrl());
		return dto;
	}
	
	public BookEntity toEntity(BookDTO dto, BookEntity entity) {
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setSummary(dto.getSummary());
		entity.setPages(dto.getPages());
		entity.setLanguage(dto.getLanguage());
		entity.setImageUrl(dto.getImageUrl());
		return entity;
	}
}
