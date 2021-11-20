package demo.converter.order;

import org.springframework.stereotype.Component;

import demo.dto.order.PaymentDTO;
import demo.entity.order.PaymentEntity;

@Component
public class PaymentConverter {
	public PaymentEntity toEntity(PaymentDTO dto) {
		PaymentEntity entity = new PaymentEntity();
		entity.setAmount(dto.getAmount());
		return entity;
	}
	
	public PaymentDTO toDTO(PaymentEntity entity) {
		PaymentDTO dto = new PaymentDTO();
		dto.setAmount(entity.getAmount());
		return dto;
	}
	
	public PaymentEntity toEntity(PaymentDTO dto, PaymentEntity entity) {
		
		entity.setAmount(dto.getAmount());
		return entity;
	}
}
