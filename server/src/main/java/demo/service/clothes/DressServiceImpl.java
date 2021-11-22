package demo.service.clothes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.clothes.DressConverter;
import demo.dto.clothes.DressDTO;
import demo.entity.clothes.DressEntity;
import demo.repository.clothes.DressRepositoy;



@Service
public class DressServiceImpl implements DressService{

	@Autowired 
	private DressRepositoy dressRepository;
	
	@Autowired
	private DressConverter dressConverter;

	@Override
	public DressDTO save(DressDTO DressDTO) {
		DressEntity DressEntity = new DressEntity();
		if(DressDTO.getId() != 0) {
			DressEntity oldDressEntity = dressRepository.findById(DressDTO.getId()).get();
			DressEntity = dressConverter.toEntity(DressDTO, oldDressEntity);
		} else {
			DressEntity = dressConverter.toEntity(DressDTO);
		}
		
		DressEntity = dressRepository.save(DressEntity);
		return dressConverter.toDTO(DressEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			dressRepository.deleteById(item);
		}
	}

	@Override
	public List<DressDTO> findAll(Pageable pageable) {
		List<DressDTO> results = new ArrayList<>();
		List<DressEntity> entities = dressRepository.findAll(pageable).getContent();
		for(DressEntity item: entities) {
			DressDTO DressDTO = dressConverter.toDTO(item);
			results.add(DressDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}

