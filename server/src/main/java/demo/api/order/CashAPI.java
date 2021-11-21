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
import demo.dto.order.CashDTO;
import demo.service.order.CashService;

@CrossOrigin
@RestController
public class CashAPI {

	@Autowired
	private CashService CashService;
	
	@GetMapping(value = "/api/cash")
	public OrderOutput showCash(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListCash(CashService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(CashService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/cash")
	public CashDTO createCash(@RequestBody CashDTO model) {
		return CashService.save(model);
	}
	
	@PutMapping(value = "/api/Cash/{id}")
	public CashDTO updateCash(@RequestBody CashDTO model, @PathVariable("id") long id) {
		model.setAmount(id);
		return CashService.save(model);
	}
	
	@DeleteMapping(value = "/api/cash")
	public void deleteCash(@RequestBody long[] ids) {
		CashService.delete(ids);
	}
}
