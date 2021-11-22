package demo.service.clothes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.clothes.ShirtDTO;

public interface ShirtService {
	ShirtDTO save(ShirtDTO ShirtDTO);
	void delete(long[] ids);
	List<ShirtDTO> findAll(Pageable pageable);
	int totalItem();
}
