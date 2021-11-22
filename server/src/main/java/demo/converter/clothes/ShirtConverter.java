package demo.converter.clothes;

import org.springframework.stereotype.Component;

import demo.dto.clothes.ShirtDTO;
import demo.dto.clothes.TrousersDTO;
import demo.entity.clothes.ShirtEntity;
import demo.entity.clothes.TrousersEntity;

@Component
public class ShirtConverter {

	public ShirtEntity toEntity(ShirtDTO dto) {
		ShirtEntity entity = new ShirtEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setBrand(dto.getBrand());
		entity.setSize(dto.getSize());
		entity.setMaterial(dto.getMaterial());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		entity.setImageUrl(dto.getImageUrl());
		entity.setColor(dto.getColor());
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return entity;
	}
	
	public ShirtDTO toDTO(ShirtEntity entity) {
		ShirtDTO dto = new ShirtDTO();
		dto.setId(dto.getId());
		dto.setName(dto.getName());
		dto.setBrand(dto.getBrand());
		dto.setSize(dto.getSize());
		dto.setMaterial(dto.getMaterial());
		dto.setDescription(dto.getDescription());
		dto.setOrigin(dto.getOrigin());
		dto.setImageUrl(dto.getImageUrl());
		dto.setColor(dto.getColor());
		return dto;
	}
	
	public ShirtEntity toEntity(ShirtDTO dto, ShirtEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setBrand(dto.getBrand());
		entity.setSize(dto.getSize());
		entity.setMaterial(dto.getMaterial());
		entity.setDescription(dto.getDescription());
		entity.setOrigin(dto.getOrigin());
		entity.setImageUrl(dto.getImageUrl());
		entity.setColor(dto.getColor());
		return entity;
	}
}
