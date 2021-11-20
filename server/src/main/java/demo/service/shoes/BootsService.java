package demo.service.shoes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.shoes.BootsDTO;

public interface BootsService {
	BootsDTO save(BootsDTO bootsDTO);
	void delete(long[] ids);
	List<BootsDTO> findAll(Pageable pageable);
	int totalItem();
}
