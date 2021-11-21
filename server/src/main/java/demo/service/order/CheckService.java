package demo.service.order;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.order.CheckDTO;

public interface CheckService {

	CheckDTO save(CheckDTO CheckDTO);
	void delete(long[] ids);
	List<CheckDTO> findAll(Pageable pageable);
	int totalItem();
}
