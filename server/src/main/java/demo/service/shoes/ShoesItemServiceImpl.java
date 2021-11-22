package demo.service.shoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.shoes.BootsConverter;
import demo.converter.shoes.ShoesItemConverter;
import demo.dto.shoes.ShoesDTO;
import demo.dto.shoes.ShoesItemDTO;
import demo.entity.shoes.ShoesEntity;
import demo.entity.shoes.ShoesItemEntity;
import demo.repository.shoes.ShoesItemRepository;
import demo.repository.shoes.ShoesRepository;

@Service
public class ShoesItemServiceImpl implements ShoesItemService{

	@Autowired
	private ShoesItemRepository shoesItemRepository;
	
	@Autowired
	private ShoesItemConverter shoesItemConverter;
	
	@Autowired
	private ShoesRepository shoesRepository;
	
	@Autowired
	private BootsConverter shoesConverter;

	@Override
	public ShoesItemDTO save(ShoesItemDTO shoesItemDTO) {
		ShoesItemEntity shoesItemEntity = new ShoesItemEntity();
		if(shoesItemDTO.getId() != 0) {
			ShoesItemEntity oldShoesItemEntity = shoesItemRepository.findById(shoesItemDTO.getId()).get();
			shoesItemEntity = shoesItemConverter.toEntity(shoesItemDTO, oldShoesItemEntity);
		} else {
			shoesItemEntity = shoesItemConverter.toEntity(shoesItemDTO);
		}
		ShoesEntity shoesEntity = shoesRepository.findOneByid(shoesItemDTO.getShoesID());
		shoesItemEntity.setShoess(shoesEntity);
		shoesItemEntity = shoesItemRepository.save(shoesItemEntity);
		return shoesItemConverter.toDTO(shoesItemEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			shoesItemRepository.deleteById(item);
		}
	}

	@Override
	public List<ShoesItemDTO> findAll(Pageable pageable) {
		List<ShoesItemDTO> results = new ArrayList<>();
		List<ShoesItemEntity> entities = shoesItemRepository.findAll(pageable).getContent();
		List<ShoesDTO> results1 = new ArrayList<>();
		List<ShoesEntity> entities2 = shoesRepository.findAll(pageable).getContent();
		for(ShoesItemEntity item: entities) {
			ShoesItemDTO ShoesItemDTO = shoesItemConverter.toDTO(item);
			results.add(ShoesItemDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
