package demo.service.shoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.shoes.BootsConverter;
import demo.dto.shoes.BootsDTO;
import demo.entity.shoes.BootsEntity;
import demo.repository.shoes.BootsRepository;

@Service
public class BootsServiceImpl implements BootsService{

	@Autowired 
	private BootsRepository bootsRepository;
	
	@Autowired
	private BootsConverter bootsConverter;

	@Override
	public BootsDTO save(BootsDTO bootsDTO) {
		BootsEntity bootsEntity = new BootsEntity();
		if(bootsDTO.getId() != 0) {
			BootsEntity oldBootsEntity = bootsRepository.findById(bootsDTO.getId()).get();
			bootsEntity = bootsConverter.toEntity(bootsDTO, oldBootsEntity);
		} else {
			bootsEntity = bootsConverter.toEntity(bootsDTO);
		}
		
		bootsEntity = bootsRepository.save(bootsEntity);
		return bootsConverter.toDTO(bootsEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			bootsRepository.deleteById(item);
		}
	}

	@Override
	public List<BootsDTO> findAll(Pageable pageable) {
		List<BootsDTO> results = new ArrayList<>();
		List<BootsEntity> entities = bootsRepository.findAll(pageable).getContent();
		for(BootsEntity item: entities) {
			BootsDTO BootsDTO = bootsConverter.toDTO(item);
			results.add(BootsDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
