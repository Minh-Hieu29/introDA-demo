package demo.api.customer;

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

import demo.api.output.CustomerOutput;
import demo.dto.customer.CustomerDTO;
import demo.service.customer.CustomerService;

@CrossOrigin
@RestController
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/api/customer")
	public CustomerOutput showCustomer(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable =Sort.by("id").ascending();
		CustomerOutput result = new CustomerOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListCustomer(customerService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (customerService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/customer")
	public CustomerDTO createCustomer(@RequestBody CustomerDTO model) {
		return customerService.save(model);
	}
	
	@PutMapping(value = "/api/customer/{id}")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return customerService.save(model);
	}
	@DeleteMapping(value = "/api/customer")
	public void deleteCustomer(@RequestBody long[] ids) {
		customerService.delete(ids);
	}
}
