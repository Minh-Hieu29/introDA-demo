package demo.converter.clothes;

import org.springframework.stereotype.Component;

import demo.dto.clothes.DressDTO;
import demo.dto.clothes.TrousersDTO;
import demo.entity.clothes.DressEntity;
import demo.entity.clothes.TrousersEntity;

@Component
public class DressConverter {

	public DressEntity toEntity(DressDTO dto) {
		DressEntity entity = new DressEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setBrand(dto.getBrand());
		entity.setSize(dto.getSize());
		entity.setMaterial(dto.getMaterial());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		entity.setImageUrl(dto.getImageUrl());
		entity.setStyle(dto.getStyle());
		return entity;
	}
	
	public DressDTO toDTO(DressEntity entity) {
		DressDTO dto = new DressDTO();
		dto.setId(dto.getId());
		dto.setName(dto.getName());
		dto.setBrand(dto.getBrand());
		dto.setSize(dto.getSize());
		dto.setMaterial(dto.getMaterial());
		dto.setDescription(dto.getDescription());
		dto.setOrigin(dto.getOrigin());
		dto.setImageUrl(dto.getImageUrl());
		dto.setStyle(dto.getStyle());
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public DressEntity toEntity(DressDTO dto, DressEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setBrand(dto.getBrand());
		entity.setSize(dto.getSize());
		entity.setMaterial(dto.getMaterial());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		entity.setImageUrl(dto.getImageUrl());
		entity.setStyle(dto.getStyle());
		return entity;
	}
}

