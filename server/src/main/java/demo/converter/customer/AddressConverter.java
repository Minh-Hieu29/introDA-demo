package demo.converter.customer;

import org.springframework.stereotype.Component;

import demo.dto.customer.AddressDTO;
import demo.entity.customer.AddressEntity;

@Component
public class AddressConverter {

	public AddressEntity toEntity(AddressDTO dto) {
		AddressEntity entity = new AddressEntity();
		entity.setNumber(dto.getNumber());
		entity.setStreet(dto.getStreet());
		entity.setDistrict(dto.getDistrict());
		entity.setCity(dto.getCity());
		return entity;
	}
	
	public AddressDTO toDTO(AddressEntity entity) {
		AddressDTO dto = new AddressDTO();
		dto.setNumber(entity.getNumber());
		dto.setStreet(entity.getStreet());
		dto.setDistrict(entity.getDistrict());
		dto.setCity(entity.getCity());
		return dto;
	}
	
	public AddressEntity toEntity(AddressDTO dto, AddressEntity entity) {
		entity.setNumber(dto.getNumber());
		entity.setStreet(dto.getStreet());
		entity.setDistrict(dto.getDistrict());
		entity.setCity(dto.getCity());
		return entity;
	}
}
