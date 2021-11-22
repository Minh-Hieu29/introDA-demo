package demo.converter.book;

import org.springframework.stereotype.Component;

import demo.dto.book.BookItemDTO;
import demo.entity.book.BookItemEntity;

@Component
public class BookItemConverter {
	public BookItemEntity toEntity(BookItemDTO dto) {
		BookItemEntity entity = new BookItemEntity();
		entity.setId(dto.getId());
		entity.setBarcode(dto.getBarCode());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
	public BookItemDTO toDTO(BookItemEntity entity) {
		BookItemDTO dto = new BookItemDTO();
		if(entity.getId() != 0) {
			dto.setId(entity.getId());
		}
		dto.setBarCode(entity.getBarcode());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());

		return dto;
	}
	
	public BookItemEntity toEntity(BookItemDTO dto, BookItemEntity entity) {
		entity.setId(dto.getId());
		entity.setBarcode(dto.getBarCode());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
}
