package demo.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.order.CheckConverter;
import demo.dto.order.CheckDTO;
import demo.entity.order.CheckEntity;
import demo.repository.order.CheckRepository;
import demo.service.order.CheckService;

@Service
public class CheckServiceImpl implements CheckService{

	@Autowired 
	private CheckRepository CheckRepository;
	
	@Autowired
	private CheckConverter CheckConverter;

	@Override
	public CheckDTO save(CheckDTO CheckDTO) {
		CheckEntity CheckEntity = new CheckEntity();
		if(CheckEntity.getId() != 0) {
			CheckEntity oldCheckEntity = CheckRepository.findById(CheckEntity.getId()).get();
			CheckEntity = CheckConverter.toEntity(CheckDTO, oldCheckEntity);
		} else {
			CheckEntity = CheckConverter.toEntity(CheckDTO);
		}
		CheckEntity = CheckRepository.save(CheckEntity);
		return CheckConverter.toDTO(CheckEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			CheckRepository.deleteById(item);
		}
	}

	@Override
	public List<CheckDTO> findAll(Pageable pageable) {
		List<CheckDTO> results = new ArrayList<>();
		List<CheckEntity> entities = CheckRepository.findAll(pageable).getContent();
		for(CheckEntity item: entities) {
			CheckDTO CheckDTO = CheckConverter.toDTO(item);
			results.add(CheckDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
