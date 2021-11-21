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
import demo.dto.order.CheckDTO;
import demo.service.order.CheckService;

@CrossOrigin
@RestController
public class CheckAPI {

	@Autowired
	private CheckService CheckService;
	
	@GetMapping(value = "/api/check")
	public OrderOutput showCheck(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListCheck(CheckService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(CheckService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/check")
	public CheckDTO createCheck(@RequestBody CheckDTO model) {
		return CheckService.save(model);
	}
	
	@PutMapping(value = "/api/check/{id}")
	public CheckDTO updateCheck(@RequestBody CheckDTO model, @PathVariable("id") long id) {
		model.setAmount(id);
		return CheckService.save(model);
	}
	
	@DeleteMapping(value = "/api/check")
	public void deleteCheck(@RequestBody long[] ids) {
		CheckService.delete(ids);
	}
}
