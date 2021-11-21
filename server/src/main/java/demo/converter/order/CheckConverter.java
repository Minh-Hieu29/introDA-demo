package demo.converter.order;

import org.springframework.stereotype.Component;

import demo.dto.order.CheckDTO;
import demo.entity.order.CheckEntity;

@Component
public class CheckConverter {
	public CheckEntity toEntity(CheckDTO dto) {
		CheckEntity entity = new CheckEntity();
		entity.setAmount(dto.getAmount());
		entity.setName(dto.getName());
		entity.setBankID(dto.getBankID());
		return entity;
	}
	
	public CheckDTO toDTO(CheckEntity entity) {
		CheckDTO dto = new CheckDTO();
		dto.setAmount(entity.getAmount());
		dto.setName(entity.getName());
		dto.setBankID(entity.getBankID());
		return dto;
	}
	
	public CheckEntity toEntity(CheckDTO dto, CheckEntity entity) {
		entity.setName(dto.getName());
		entity.setBankID(dto.getBankID());
		entity.setAmount(dto.getAmount());
		return entity;
	}
}
