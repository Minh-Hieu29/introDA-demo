package demo.service.order;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.order.CreditDTO;

public interface CreditService {
	CreditDTO save(CreditDTO CreditDTO);
	void delete(long[] ids);
	List<CreditDTO> findAll(Pageable pageable);
	int totalItem();
}
