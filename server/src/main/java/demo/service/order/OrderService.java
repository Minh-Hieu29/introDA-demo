package demo.service.order;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.order.OrderDTO;

public interface OrderService {
	OrderDTO save(OrderDTO orderDTO);
	void delete(long[] ids);
	List<OrderDTO> findAll(Pageable pageable);
	int totalItem();
}
