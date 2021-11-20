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
		entity.setModel(dto.getModel());
		entity.setHeight(dto.getHeight());
		return entity;
	}
	
	public BootsDTO toDTO(BootsEntity entity) {
		BootsDTO dto = new BootsDTO();
		dto.setId(entity.getId());
		dto.setSize(entity.getSize());
		dto.setColor(entity.getColor());
		dto.setMaterial(entity.getMaterial());
		dto.setModel(entity.getModel());
		dto.setHeight(entity.getHeight());
		return dto;
	}
	
	public BootsEntity toEntity(BootsDTO dto, BootsEntity entity) {
		entity.setId(dto.getId());
		entity.setSize(dto.getSize());
		entity.setColor(dto.getColor());
		entity.setMaterial(dto.getMaterial());
		entity.setModel(dto.getModel());
		entity.setHeight(dto.getHeight());
		return entity;
	}
}
