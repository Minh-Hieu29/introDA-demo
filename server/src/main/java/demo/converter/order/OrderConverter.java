package demo.converter.order;

import org.springframework.stereotype.Component;

import demo.dto.order.OrderDTO;
import demo.entity.order.OrderEntity;

@Component
public class OrderConverter {
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity entity = new OrderEntity();
		entity.setId(dto.getId());
		entity.setDateCreate(dto.getDateCreate());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public OrderDTO toDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setDateCreate(entity.getDateCreate());
		dto.setStatus(entity.getStatus());
		return dto;
	}
	
	public OrderEntity toEntity(OrderDTO dto, OrderEntity entity) {
		entity.setId(dto.getId());
		entity.setDateCreate(dto.getDateCreate());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
