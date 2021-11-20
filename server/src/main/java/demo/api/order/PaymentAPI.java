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
import demo.dto.order.PaymentDTO;
import demo.service.order.PaymentService;

@CrossOrigin
@RestController
public class PaymentAPI {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = "/api/payment")
	public OrderOutput showPayment(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListPayment(paymentService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(paymentService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/payment")
	public PaymentDTO createPayment(@RequestBody PaymentDTO model) {
		return paymentService.save(model);
	}
	
//	@PutMapping(value = "/api/payment/{id}")
//	public PaymentDTO updatePayment(@RequestBody PaymentDTO model, @PathVariable("id") long id) {
//		model.setAmount(id);
//		return paymentService.save(model);
//	}
	
	@DeleteMapping(value = "/api/payment")
	public void deletePayment(@RequestBody long[] ids) {
		paymentService.delete(ids);
	}
}
