package demo.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.order.CreditConverter;
import demo.dto.order.CreditDTO;
import demo.entity.order.CreditEntity;
import demo.repository.order.CreditRepository;
import demo.service.order.CreditService;

@Service
public class CreditServiceImpl implements CreditService{

	@Autowired 
	private CreditRepository CreditRepository;
	
	@Autowired
	private CreditConverter CreditConverter;

	@Override
	public CreditDTO save(CreditDTO CreditDTO) {
		CreditEntity CreditEntity = new CreditEntity();
		if(CreditEntity.getId() != 0) {
			CreditEntity oldCreditEntity = CreditRepository.findById(CreditEntity.getId()).get();
			CreditEntity = CreditConverter.toEntity(CreditDTO, oldCreditEntity);
		} else {
			CreditEntity = CreditConverter.toEntity(CreditDTO);
		}
		CreditEntity = CreditRepository.save(CreditEntity);
		return CreditConverter.toDTO(CreditEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			CreditRepository.deleteById(item);
		}
	}

	@Override
	public List<CreditDTO> findAll(Pageable pageable) {
		List<CreditDTO> results = new ArrayList<>();
		List<CreditEntity> entities = CreditRepository.findAll(pageable).getContent();
		for(CreditEntity item: entities) {
			CreditDTO CreditDTO = CreditConverter.toDTO(item);
			results.add(CreditDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
