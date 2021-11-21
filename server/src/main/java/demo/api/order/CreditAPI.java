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
import demo.dto.order.CreditDTO;
import demo.service.order.CreditService;

@CrossOrigin
@RestController
public class CreditAPI {

	@Autowired
	private CreditService CreditService;
	
	@GetMapping(value = "/api/credit")
	public OrderOutput showCredit(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListCredit(CreditService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(CreditService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/credit")
	public CreditDTO createCredit(@RequestBody CreditDTO model) {
		return CreditService.save(model);
	}
	
	@PutMapping(value = "/api/credit/{id}")
	public CreditDTO updateCredit(@RequestBody CreditDTO model, @PathVariable("id") long id) {
		model.setAmount(id);
		return CreditService.save(model);
	}
	
	@DeleteMapping(value = "/api/credit")
	public void deleteCredit(@RequestBody long[] ids) {
		CreditService.delete(ids);
	}
}
