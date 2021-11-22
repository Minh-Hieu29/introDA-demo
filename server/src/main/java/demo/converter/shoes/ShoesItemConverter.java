package demo.converter.shoes;

import org.springframework.stereotype.Component;

import demo.dto.shoes.ShoesItemDTO;
import demo.entity.shoes.ShoesItemEntity;



@Component
public class ShoesItemConverter {
	public ShoesItemEntity toEntity(ShoesItemDTO dto) {
		ShoesItemEntity entity = new ShoesItemEntity();
		entity.setId(dto.getId());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
	public ShoesItemDTO toDTO(ShoesItemEntity entity) {
		ShoesItemDTO dto = new ShoesItemDTO();
		dto.setId(entity.getId());
		dto.setPrice(entity.getPrice());
		dto.setDiscount(entity.getDiscount());
		return dto;
	}
	
	public ShoesItemEntity toEntity(ShoesItemDTO dto, ShoesItemEntity entity) {
		entity.setId(dto.getId());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		return entity;
	}
	
}
