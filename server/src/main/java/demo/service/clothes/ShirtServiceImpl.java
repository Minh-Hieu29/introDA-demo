package demo.service.clothes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.clothes.ShirtConverter;
import demo.dto.clothes.ShirtDTO;
import demo.entity.clothes.ShirtEntity;
import demo.repository.clothes.ShirtRepositoy;



@Service
public class ShirtServiceImpl implements ShirtService{

	@Autowired 
	private ShirtRepositoy ShirtRepository;
	
	@Autowired
	private ShirtConverter ShirtConverter;

	@Override
	public ShirtDTO save(ShirtDTO ShirtDTO) {
		ShirtEntity ShirtEntity = new ShirtEntity();
		if(ShirtDTO.getId() != 0) {
			ShirtEntity oldShirtEntity = ShirtRepository.findById(ShirtDTO.getId()).get();
			ShirtEntity = ShirtConverter.toEntity(ShirtDTO, oldShirtEntity);
		} else {
			ShirtEntity = ShirtConverter.toEntity(ShirtDTO);
		}
		
		ShirtEntity = ShirtRepository.save(ShirtEntity);
		return ShirtConverter.toDTO(ShirtEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			ShirtRepository.deleteById(item);
		}
	}

	@Override
	public List<ShirtDTO> findAll(Pageable pageable) {
		List<ShirtDTO> results = new ArrayList<>();
		List<ShirtEntity> entities = ShirtRepository.findAll(pageable).getContent();
		for(ShirtEntity item: entities) {
			ShirtDTO ShirtDTO = ShirtConverter.toDTO(item);
			results.add(ShirtDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}

