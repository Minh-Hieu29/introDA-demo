package demo.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.book.PublisherConverter;
import demo.dto.book.PublisherDTO;
import demo.entity.book.PublisherEntity;
import demo.repository.book.PublisherRepository;
import demo.service.book.PublisherServiceImpl;

@Service
public class PublisherService implements PublisherServiceImpl{

	@Autowired
	private PublisherConverter publisherConverter;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	public PublisherDTO save(PublisherDTO publisherDTO) {
		PublisherEntity publisherEntity = new PublisherEntity();
		if(publisherDTO.getId() != 0) {
			PublisherEntity oldPublisherEntity = publisherRepository.findById(publisherDTO.getId()).get();
			publisherEntity = publisherConverter.toEntity(publisherDTO, oldPublisherEntity);
		} else {
			publisherEntity = publisherConverter.toEntity(publisherDTO);
		}
		publisherEntity = publisherRepository.save(publisherEntity);
		return publisherConverter.toDTO(publisherEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			publisherRepository.deleteById(item);
		}
		
	}

	@Override
	public List<PublisherDTO> findAll(Pageable pageable) {
		List<PublisherDTO> results = new ArrayList<>();
		List<PublisherEntity> entities = publisherRepository.findAll(pageable).getContent();
		for(PublisherEntity item: entities) {
			PublisherDTO publisherDTO = publisherConverter.toDTO(item);
			results.add(publisherDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
