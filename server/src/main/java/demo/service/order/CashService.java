package demo.service.order;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.order.CashDTO;

public interface CashService {

	CashDTO save(CashDTO CashDTO);
	void delete(long[] ids);
	List<CashDTO> findAll(Pageable pageable);
	int totalItem();
}
