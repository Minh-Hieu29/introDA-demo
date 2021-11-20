package demo.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.order.OrderConverter;
import demo.dto.order.OrderDTO;
import demo.entity.order.CartEntity;
import demo.entity.order.OrderEntity;
import demo.entity.order.PaymentEntity;
import demo.entity.order.ShipmentEntity;
import demo.repository.order.CartRepository;
import demo.repository.order.OrderRepository;
import demo.repository.order.PaymentRepository;
import demo.repository.order.ShipmentRepository;
import demo.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderConverter orderConverter;

	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		OrderEntity orderEntity = new OrderEntity();
		if(orderDTO.getId() != 0) {
			OrderEntity oldOrderEntity = orderRepository.findById(orderDTO.getId()).get();
			orderEntity = orderConverter.toEntity(orderDTO, oldOrderEntity);
		} else {
			orderEntity = orderConverter.toEntity(orderDTO);
		}
		CartEntity cartEntity = cartRepository.findOneById(orderDTO.getCartQuantity());
		orderEntity.setCart(cartEntity);
		PaymentEntity paymentEntity = paymentRepository.findOneById(orderDTO.getPaymentAmount());
		orderEntity.setPayment(paymentEntity);
		ShipmentEntity shipmentEntity = shipmentRepository.findOneById(orderDTO.getShipmentName());
		orderEntity.setShipment(shipmentEntity);
		orderEntity = orderRepository.save(orderEntity);
		return orderConverter.toDTO(orderEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			orderRepository.deleteById(item);
		}
		
	}

	@Override
	public List<OrderDTO> findAll(Pageable pageable) {
		List<OrderDTO> results = new ArrayList<>();
		List<OrderEntity> entities = orderRepository.findAll(pageable).getContent();
		for(OrderEntity item: entities) {
			OrderDTO orderDTO = orderConverter.toDTO(item);
			results.add(orderDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
