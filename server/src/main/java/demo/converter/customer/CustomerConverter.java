package demo.converter.customer;

import org.springframework.stereotype.Component;

import demo.dto.customer.CustomerDTO;
import demo.entity.customer.CustomerEntity;

@Component
public class CustomerConverter {

	public CustomerEntity toEntity(CustomerDTO dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setId(dto.getId());
		entity.setDOB(dto.getDOB());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		return entity;
	}
	
	public CustomerDTO toDTO(CustomerEntity entity) {
		CustomerDTO dto = new CustomerDTO();
		if(entity.getId() != 0) {
			dto.setId(entity.getId());
		}
		dto.setId(entity.getId());
		dto.setDOB(entity.getDOB());
		dto.setSex(entity.getSex());
		dto.setPhone(entity.getPhone());
		return dto;
	}
	
	public CustomerEntity toEntity(CustomerDTO dto, CustomerEntity entity) {
		entity.setId(dto.getId());
		entity.setDOB(dto.getDOB());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		return entity;
	}
}
