package demo.converter.order;

import org.springframework.stereotype.Component;

import demo.dto.order.CashDTO;
import demo.entity.order.CashEntity;
@Component
public class CashConverter {
	public CashEntity toEntity(CashDTO dto) {
		CashEntity entity = new CashEntity();
		entity.setAmount(dto.getAmount());
		entity.setCashTendered(dto.getCashTenderd());
		return entity;
	}
	
	public CashDTO toDTO(CashEntity entity) {
		CashDTO dto = new CashDTO();
		dto.setAmount(entity.getAmount());
		dto.setCashTenderd(entity.getCashTendered());
		return dto;
	}
	
	public CashEntity toEntity(CashDTO dto, CashEntity entity) {
		entity.setCashTendered(dto.getCashTenderd());
		entity.setAmount(dto.getAmount());
		return entity;
	}
}
