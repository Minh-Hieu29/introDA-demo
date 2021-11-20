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
import demo.dto.order.OrderDTO;
import demo.service.order.OrderService;

@CrossOrigin
@RestController
public class OrderAPI {
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/api/order")
	public OrderOutput showOrder(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListOrder(orderService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(orderService.totalItem())/limit));
		return result;
	}
	@PostMapping(value = "/api/order")
	public OrderDTO createOrder(@RequestBody OrderDTO model) {
		return orderService.save(model);
	}
	@PutMapping(value = "/api/order/{id}")
	public OrderDTO updateOrder(@RequestBody OrderDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return orderService.save(model);
	}
	
	@DeleteMapping(value = "/api/order")
	public void deleteOrder(@RequestBody long[] ids) {
		orderService.delete(ids);
	}
}
