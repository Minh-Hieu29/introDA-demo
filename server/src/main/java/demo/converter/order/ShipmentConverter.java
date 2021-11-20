package demo.converter.order;

import org.springframework.stereotype.Component;

import demo.dto.order.ShipmentDTO;
import demo.entity.order.ShipmentEntity;

@Component
public class ShipmentConverter {
	public ShipmentEntity toEntity(ShipmentDTO dto) {
		ShipmentEntity entity = new ShipmentEntity();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setAddress(dto.getAddress());
		return entity;
	}
	
	public ShipmentDTO toDTO(ShipmentEntity entity) {
		ShipmentDTO dto = new ShipmentDTO();
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setAddress( entity.getAddress());
		return dto;
	}
	
	public ShipmentEntity toEntity(ShipmentDTO dto, ShipmentEntity entity) {
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setAddress(dto.getAddress());
		return entity;
	}
}
