package demo.converter.customer;

import org.springframework.stereotype.Component;

import demo.dto.customer.CustomerDTO;
import demo.entity.customer.CustomerEntity;

@Component
public class CustomerConverter {

	public CustomerEntity toEntity(CustomerDTO dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setId(dto.getId());
		entity.setDob(dto.getDob());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		return entity;
	}
	
	public CustomerDTO toDTO(CustomerEntity entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(entity.getId());
		dto.setDob(entity.getDob());
		dto.setSex(entity.getSex());
		dto.setPhone(entity.getPhone());
		dto.setCreaterDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	
	public CustomerEntity toEntity(CustomerDTO dto, CustomerEntity entity) {
		entity.setId(dto.getId());
		entity.setDob(dto.getDob());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		return entity;
	}
}
