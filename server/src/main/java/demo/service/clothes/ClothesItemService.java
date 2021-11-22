package demo.service.clothes;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.clothes.ClothesItemDTO;

public interface ClothesItemService {

	ClothesItemDTO save(ClothesItemDTO ClothesItemDTO);
	void delete(long[] ids);
	List<ClothesItemDTO> findAll(Pageable pageable);
	int totalItem();
}
