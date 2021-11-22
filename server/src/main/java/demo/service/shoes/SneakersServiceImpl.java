package demo.service.shoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.shoes.SneakersConverter;
import demo.dto.shoes.SneakersDTO;
import demo.entity.shoes.SneakersEntity;
import demo.repository.shoes.SneakersRepository;

@Service
public class SneakersServiceImpl implements SneakersService{

	@Autowired 
	private SneakersRepository SneakersRepository;
	
	@Autowired
	private SneakersConverter SneakersConverter;

	@Override
	public SneakersDTO save(SneakersDTO SneakersDTO) {
		SneakersEntity SneakersEntity = new SneakersEntity();
		if(SneakersDTO.getId() != 0) {
			SneakersEntity oldSneakersEntity = SneakersRepository.findById(SneakersDTO.getId()).get();
			SneakersEntity = SneakersConverter.toEntity(SneakersDTO, oldSneakersEntity);
		} else {
			SneakersEntity = SneakersConverter.toEntity(SneakersDTO);
		}
		
		SneakersEntity = SneakersRepository.save(SneakersEntity);
		return SneakersConverter.toDTO(SneakersEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			SneakersRepository.deleteById(item);
		}
	}

	@Override
	public List<SneakersDTO> findAll(Pageable pageable) {
		List<SneakersDTO> results = new ArrayList<>();
		List<SneakersEntity> entities = SneakersRepository.findAll(pageable).getContent();
		for(SneakersEntity item: entities) {
			SneakersDTO SneakersDTO = SneakersConverter.toDTO(item);
			results.add(SneakersDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
