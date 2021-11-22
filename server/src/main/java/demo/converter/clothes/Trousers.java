package demo.converter.clothes;

import org.springframework.stereotype.Component;

import demo.dto.clothes.TrousersDTO;
import demo.entity.clothes.TrousersEntity;

@Component
public class Trousers {
	public TrousersEntity toEntity(TrousersDTO dto) {
		TrousersEntity entity = new TrousersEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setBrand(dto.getBrand());
		entity.setSize(dto.getSize());
		entity.setMaterial(dto.getMaterial());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		entity.setImageUrl(dto.getImageUrl());
		entity.setHeight(dto.getHeight());
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return entity;
	}
	
	public TrousersDTO toDTO(TrousersEntity entity) {
		TrousersDTO dto = new TrousersDTO();
		dto.setId(dto.getId());
		dto.setName(dto.getName());
		dto.setBrand(dto.getBrand());
		dto.setSize(dto.getSize());
		dto.setMaterial(dto.getMaterial());
		dto.setDescription(dto.getDescription());
		dto.setOrigin(dto.getOrigin());
		dto.setImageUrl(dto.getImageUrl());
		dto.setHeight(dto.getHeight());
		return dto;
	}
	
	public TrousersEntity toEntity(TrousersDTO dto, TrousersEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setBrand(dto.getBrand());
		entity.setSize(dto.getSize());
		entity.setMaterial(dto.getMaterial());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		entity.setImageUrl(dto.getImageUrl());
		entity.setHeight(dto.getHeight());
		return entity;
	}
}
