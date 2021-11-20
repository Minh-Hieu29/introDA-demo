package demo.converter.customer;

import org.springframework.stereotype.Component;

import demo.dto.customer.AccountDTO;
import demo.entity.customer.AccountEntity;

@Component
public class AccountConverter {
	public AccountEntity toEntity(AccountDTO dto) {
		AccountEntity entity = new AccountEntity();
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		return entity;
	}
	
	public AccountDTO toDTO(AccountEntity entity) {
		AccountDTO dto = new AccountDTO();
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		return dto;
	}
	
	public AccountEntity toEntity(AccountDTO dto, AccountEntity entity) {
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		return entity;
	}
}
