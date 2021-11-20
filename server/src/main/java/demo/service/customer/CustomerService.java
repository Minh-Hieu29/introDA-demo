package demo.service.customer;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.customer.CustomerDTO;

public interface CustomerService {
	CustomerDTO save(CustomerDTO customerDTO);
	void delete(long[] ids);
	List<CustomerDTO> findAll(Pageable pageable);
	int totalItem();
}
