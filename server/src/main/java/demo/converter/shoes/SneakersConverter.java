package demo.converter.shoes;

import org.springframework.stereotype.Component;

import demo.dto.shoes.SneakersDTO;
import demo.entity.shoes.SneakersEntity;

@Component
public class SneakersConverter {

	public SneakersEntity toEntity(SneakersDTO dto) {
		SneakersEntity entity = new SneakersEntity();
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
	
	public SneakersDTO toDTO(SneakersEntity entity) {
		SneakersDTO dto = new SneakersDTO();
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
	
	public SneakersEntity toEntity(SneakersDTO dto, SneakersEntity entity) {
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
