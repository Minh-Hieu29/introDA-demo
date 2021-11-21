package demo.converter.shoes;

import org.springframework.stereotype.Component;

import demo.dto.shoes.ShoesDTO;
import demo.entity.shoes.ShoesEntity;

@Component
public class ShoesConverter {

	public ShoesEntity toEntity(ShoesDTO dto) {
		ShoesEntity entity = new ShoesEntity();
		entity.setId(dto.getId());
		entity.setSize(dto.getSize());
		entity.setColor(dto.getColor());
		entity.setMaterial(dto.getMaterial());
		entity.setModel(dto.getModel());
		entity.setImageUrl(dto.getImageUrl());
		return entity;
	}
	
	public ShoesDTO toDTO(ShoesEntity entity) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(entity.getId());
		dto.setSize(entity.getSize());
		dto.setColor(entity.getColor());
		dto.setMaterial(entity.getMaterial());
		dto.setModel(entity.getModel());
		dto.setImageUrl(entity.getImageUrl());
		return dto;
	}
	
	public ShoesEntity toEntity(ShoesDTO dto, ShoesEntity entity) {
		entity.setId(dto.getId());
		entity.setSize(dto.getSize());
		entity.setColor(dto.getColor());
		entity.setMaterial(dto.getMaterial());
		entity.setModel(dto.getModel());
		entity.setImageUrl(dto.getImageUrl());
		return entity;
	}
}
