package demo.converter.book;

import org.springframework.stereotype.Component;

import demo.dto.book.CategoryDTO;
import demo.entity.book.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(dto.getName());
		return entity;
	}
	
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setName(entity.getName());
		return dto;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setName(dto.getName());
		return entity;
	}
}
