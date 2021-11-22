package demo.service.clothes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.clothes.Trousers;
import demo.converter.clothes.Trousers;
import demo.dto.clothes.TrousersDTO;
import demo.entity.clothes.TrousersEntity;
import demo.repository.clothes.TrousersRepositoy;



@Service
public class TrousersServiceImpl implements TrousersService{

	@Autowired 
	private TrousersRepositoy TrousersRepository;
	
	@Autowired
	private Trousers TrousersConverter;

	@Override
	public TrousersDTO save(TrousersDTO TrousersDTO) {
		TrousersEntity TrousersEntity = new TrousersEntity();
		if(TrousersDTO.getId() != 0) {
			TrousersEntity oldTrousersEntity = TrousersRepository.findById(TrousersDTO.getId()).get();
			TrousersEntity = TrousersConverter.toEntity(TrousersDTO, oldTrousersEntity);
		} else {
			TrousersEntity = TrousersConverter.toEntity(TrousersDTO);
		}
		
		TrousersEntity = TrousersRepository.save(TrousersEntity);
		return TrousersConverter.toDTO(TrousersEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			TrousersRepository.deleteById(item);
		}
	}

	@Override
	public List<TrousersDTO> findAll(Pageable pageable) {
		List<TrousersDTO> results = new ArrayList<>();
		List<TrousersEntity> entities = TrousersRepository.findAll(pageable).getContent();
		for(TrousersEntity item: entities) {
			TrousersDTO TrousersDTO = TrousersConverter.toDTO(item);
			results.add(TrousersDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}


