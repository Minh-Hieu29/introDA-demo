package demo.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.api.output.OrderOutput;
import demo.dto.order.ShipmentDTO;
import demo.service.order.ShipmentService;

@CrossOrigin
@RestController
public class ShipmentAPI {
	@Autowired
	private ShipmentService shipmentService;
	
	@GetMapping(value = "/api/shipment")
	public OrderOutput showShipment(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListShipment(shipmentService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (shipmentService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/shipment")
	public ShipmentDTO createShipment(@RequestBody ShipmentDTO model) {
		return shipmentService.save(model);
	}
	
	@PutMapping(value = "/api/shipment/{id}")
	public ShipmentDTO updateShipment(@RequestBody ShipmentDTO model, @PathVariable("id") String id) {
		model.setName(id);
		return shipmentService.save(model);
	}
	
	@DeleteMapping(value = "/api/shipment")
	public void deleteShipment(@RequestBody long[] ids) {
		shipmentService.delete(ids);
	}
}
