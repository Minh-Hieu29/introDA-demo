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
import demo.dto.customer.CustomerMemberDTO;
import demo.dto.customer.CustomerNewDTO;
import demo.service.customer.CustomerMemberService;

@CrossOrigin
@RestController
public class CustomerMemberAPI {

	@Autowired
	private CustomerMemberService customerMemberService;
	
	@GetMapping(value = "/api/customer-member")
	public CustomerOutput showCustomer(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable =Sort.by("id").ascending();
		CustomerOutput result = new CustomerOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListCustomerMember(customerMemberService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (customerMemberService.totalItem())/limit));
		return result;
	}
	@PostMapping(value = "/api/customer-member")
	public CustomerMemberDTO createCustomer(@RequestBody CustomerMemberDTO model) {
		return customerMemberService.save(model);
	}
	
	@PutMapping(value = "/api/customer-member/{id}")
	public CustomerMemberDTO updateCustomer(@RequestBody CustomerMemberDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return customerMemberService.save(model);
	}
	@DeleteMapping(value = "/api/customer-member")
	public void deleteCustomer(@RequestBody long[] ids) {
		customerMemberService.delete(ids);
	}
}
