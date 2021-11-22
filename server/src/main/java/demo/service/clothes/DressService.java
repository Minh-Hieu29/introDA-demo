package demo.service.clothes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.clothes.DressDTO;

public interface DressService {

	DressDTO save(DressDTO DressDTO);
	void delete(long[] ids);
	List<DressDTO> findAll(Pageable pageable);
	int totalItem();
}
