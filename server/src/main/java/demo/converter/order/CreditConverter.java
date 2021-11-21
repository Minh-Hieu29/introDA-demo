package demo.converter.order;

import org.springframework.stereotype.Component;

import demo.dto.order.CreditDTO;
import demo.entity.order.CreditEntity;

@Component
public class CreditConverter {

	public CreditEntity toEntity(CreditDTO dto) {
		CreditEntity entity = new CreditEntity();
		entity.setAmount(dto.getAmount());
		entity.setNumber(dto.getNumber());
		entity.setType(dto.getType());
		entity.setDate(dto.getDate());
		return entity;
	}
	
	public CreditDTO toDTO(CreditEntity entity) {
		CreditDTO dto = new CreditDTO();
		dto.setAmount(entity.getAmount());
		dto.setNumber(entity.getNumber());
		dto.setType(entity.getType());
		dto.setDate(entity.getDate());
		return dto;
	}
	
	public CreditEntity toEntity(CreditDTO dto, CreditEntity entity) {
		entity.setNumber(dto.getNumber());
		entity.setType(dto.getType());
		entity.setDate(dto.getDate());
		entity.setAmount(dto.getAmount());
		return entity;
	}
}
