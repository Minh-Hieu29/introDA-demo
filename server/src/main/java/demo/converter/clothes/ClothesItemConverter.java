package demo.converter.clothes;

import org.springframework.stereotype.Component;

import demo.dto.clothes.ClothesItemDTO;
import demo.entity.clothes.ClothesItemEntity;

@Component
public class ClothesItemConverter {

	public ClothesItemEntity toEntity(ClothesItemDTO dto) {
		ClothesItemEntity entity = new ClothesItemEntity();
		entity.setId(dto.getId());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
	public ClothesItemDTO toDTO(ClothesItemEntity entity) {
		ClothesItemDTO dto = new ClothesItemDTO();
		dto.setId(entity.getId());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public ClothesItemEntity toEntity(ClothesItemDTO dto, ClothesItemEntity entity) {
		entity.setId(dto.getId());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
}
