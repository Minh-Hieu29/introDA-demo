package demo.converter.customer;

import org.springframework.stereotype.Component;

import demo.dto.customer.CustomerNewDTO;
import demo.entity.customer.CustomerNewEntity;

@Component
public class CustomerNewConverter {
	public CustomerNewEntity toEntity(CustomerNewDTO dto) {
		CustomerNewEntity entity = new CustomerNewEntity();
		entity.setId(dto.getId());
		entity.setDob(dto.getDob());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		entity.setNote(dto.getNote());
		return entity;
	}
	
	public CustomerNewDTO toDTO(CustomerNewEntity entity) {
		CustomerNewDTO dto = new CustomerNewDTO();
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());		
		dto.setId(entity.getId());
		dto.setDob(entity.getDob());
		dto.setSex(entity.getSex());
		dto.setPhone(entity.getPhone());
		dto.setNote(entity.getNote());
		return dto;
	}
	
	public CustomerNewEntity toEntity(CustomerNewDTO dto, CustomerNewEntity entity) {
		entity.setId(dto.getId());
		entity.setDob(dto.getDob());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		entity.setNote(dto.getNote());
		return entity;
	}
}
