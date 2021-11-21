package demo.service.customer;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.customer.CustomerMemberDTO;

public interface CustomerMemberService {

	CustomerMemberDTO save(CustomerMemberDTO model);
	void delete(long[] ids);
	List<CustomerMemberDTO> findAll(Pageable pageable);
	int totalItem();
}
