package demo.service.order;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.order.ShipmentDTO;

public interface ShipmentService {
	ShipmentDTO save(ShipmentDTO shipmentDTO);
	void delete(long[] ids);
	List<ShipmentDTO> findAll(Pageable pageable);
	int totalItem();
}
