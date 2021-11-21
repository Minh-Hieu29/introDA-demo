package demo.service.customer;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.customer.CustomerNewDTO;

public interface CustomerNewService {

	CustomerNewDTO save(CustomerNewDTO model);
	void delete(long[] ids);
	List<CustomerNewDTO> findAll(Pageable pageable);
	int totalItem();
}
