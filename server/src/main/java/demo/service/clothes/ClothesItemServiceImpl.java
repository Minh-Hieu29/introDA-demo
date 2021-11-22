package demo.service.clothes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.clothes.ClothesItemConverter;
import demo.dto.clothes.ClothesItemDTO;
import demo.entity.clothes.ClothesEntity;
import demo.entity.clothes.ClothesItemEntity;
import demo.repository.clothes.ClothesItemRepositoy;
import demo.repository.clothes.ClothesRepositoy;



@Service
public class ClothesItemServiceImpl implements ClothesItemService{

	@Autowired 
	private ClothesItemRepositoy ClothesItemRepository;
	
	@Autowired
	private ClothesItemConverter ClothesItemConverter;
	
	@Autowired 
	private ClothesRepositoy clothesRepositoy;

	@Override
	public ClothesItemDTO save(ClothesItemDTO ClothesItemDTO) {
		ClothesItemEntity ClothesItemEntity = new ClothesItemEntity();
		if(ClothesItemDTO.getId() != 0) {
			ClothesItemEntity oldClothesItemEntity = ClothesItemRepository.findById(ClothesItemDTO.getId()).get();
			ClothesItemEntity = ClothesItemConverter.toEntity(ClothesItemDTO, oldClothesItemEntity);
		} else {
			ClothesItemEntity = ClothesItemConverter.toEntity(ClothesItemDTO);
		}
		ClothesEntity clothesEntity = clothesRepositoy.findOneById(ClothesItemDTO.getClothesId());
		ClothesItemEntity.setClothes(clothesEntity);
		ClothesItemEntity = ClothesItemRepository.save(ClothesItemEntity);
		return ClothesItemConverter.toDTO(ClothesItemEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			ClothesItemRepository.deleteById(item);
		}
	}

	@Override
	public List<ClothesItemDTO> findAll(Pageable pageable) {
		List<ClothesItemDTO> results = new ArrayList<>();
		List<ClothesItemEntity> entities = ClothesItemRepository.findAll(pageable).getContent();
		for(ClothesItemEntity item: entities) {
			ClothesItemDTO ClothesItemDTO = ClothesItemConverter.toDTO(item);
			results.add(ClothesItemDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}


