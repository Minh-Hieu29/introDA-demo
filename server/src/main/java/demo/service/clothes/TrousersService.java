package demo.service.clothes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.clothes.TrousersDTO;

public interface TrousersService {

	TrousersDTO save(TrousersDTO TrousersDTO);
	void delete(long[] ids);
	List<TrousersDTO> findAll(Pageable pageable);
	int totalItem();
}
