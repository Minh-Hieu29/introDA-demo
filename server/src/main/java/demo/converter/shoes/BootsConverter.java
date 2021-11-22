package demo.converter.shoes;

import org.springframework.stereotype.Component;

import demo.dto.shoes.BootsDTO;
import demo.entity.shoes.BootsEntity;

@Component
public class BootsConverter {

	public BootsEntity toEntity(BootsDTO dto) {
		BootsEntity entity = new BootsEntity();
		entity.setId(dto.getId());
		entity.setSize(dto.getSize());
		entity.setColor(dto.getColor());
		entity.setMaterial(dto.getMaterial());
		entity.setImageUrl(dto.getImageUrl());
		entity.setBrand(dto.getBrand());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		return entity;
	}
	
	public BootsDTO toDTO(BootsEntity entity) {
		BootsDTO dto = new BootsDTO();
		dto.setId(entity.getId());
		dto.setSize(entity.getSize());
		dto.setColor(entity.getColor());
		dto.setMaterial(entity.getMaterial());
		dto.setBrand(entity.getBrand());
		dto.setName(entity.getName());
		dto.setOrigin(entity.getOrigin());
		dto.setDescription(entity.getDescription());
		dto.setImageUrl(entity.getImageUrl());
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public BootsEntity toEntity(BootsDTO dto, BootsEntity entity) {
		entity.setId(dto.getId());
		entity.setSize(dto.getSize());
		entity.setColor(dto.getColor());
		entity.setMaterial(dto.getMaterial());
		entity.setImageUrl(dto.getImageUrl());
		entity.setBrand(dto.getBrand());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		return entity;
	}
}
