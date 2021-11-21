package demo.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.order.CashConverter;
import demo.dto.order.CashDTO;
import demo.entity.order.CashEntity;
import demo.repository.order.CashRepository;
import demo.service.order.CashService;

@Service
public class CashServiceImpl implements CashService{

	@Autowired 
	private CashRepository cashRepository;
	
	@Autowired
	private CashConverter cashConverter;

	@Override
	public CashDTO save(CashDTO CashDTO) {
		CashEntity CashEntity = new CashEntity();
		if(CashEntity.getId() != 0) {
			CashEntity oldCashEntity = cashRepository.findById(CashEntity.getId()).get();
			CashEntity = cashConverter.toEntity(CashDTO, oldCashEntity);
		} else {
			CashEntity = cashConverter.toEntity(CashDTO);
		}
		CashEntity = cashRepository.save(CashEntity);
		return cashConverter.toDTO(CashEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			cashRepository.deleteById(item);
		}
	}

	@Override
	public List<CashDTO> findAll(Pageable pageable) {
		List<CashDTO> results = new ArrayList<>();
		List<CashEntity> entities = cashRepository.findAll(pageable).getContent();
		for(CashEntity item: entities) {
			CashDTO CashDTO = cashConverter.toDTO(item);
			results.add(CashDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
