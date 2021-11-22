package demo.service.shoes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.shoes.SneakersDTO;

public interface SneakersService {

	SneakersDTO save(SneakersDTO SneakersDTO);
	void delete(long[] ids);
	List<SneakersDTO> findAll(Pageable pageable);
	int totalItem();
}
