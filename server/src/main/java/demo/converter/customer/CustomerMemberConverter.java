package demo.converter.customer;

import org.springframework.stereotype.Component;

import demo.dto.customer.CustomerMemberDTO;
import demo.entity.customer.CustomerMemberEntity;

@Component
public class CustomerMemberConverter {

	public CustomerMemberEntity toEntity(CustomerMemberDTO dto) {
		CustomerMemberEntity entity = new CustomerMemberEntity();
		entity.setId(dto.getId());
		entity.setDob(dto.getDob());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		entity.setCardNumber(dto.getCardNumber());
		return entity;
	}
	
	public CustomerMemberDTO toDTO(CustomerMemberEntity entity) {
		CustomerMemberDTO dto = new CustomerMemberDTO();
		
			dto.setId(entity.getId());
		
		dto.setId(entity.getId());
		dto.setDob(entity.getDob());
		dto.setSex(entity.getSex());
		dto.setPhone(entity.getPhone());
		dto.setCardNumber(entity.getCardNumber());
		return dto;
	}
	
	public CustomerMemberEntity toEntity(CustomerMemberDTO dto, CustomerMemberEntity entity) {
		entity.setId(dto.getId());
		entity.setDob(dto.getDob());
		entity.setSex(dto.getSex());
		entity.setPhone(dto.getPhone());
		entity.setCardNumber(dto.getCardNumber());
		return entity;
	}
}
