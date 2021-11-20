package demo.service.shoes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.shoes.ShoesItemDTO;

public interface ShoesItemService {

	ShoesItemDTO save(ShoesItemDTO ShoesItemDTO);
	void delete(long[] ids);
	List<ShoesItemDTO> findAll(Pageable pageable);
	int totalItem();
}
