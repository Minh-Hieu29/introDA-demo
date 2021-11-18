package demo.converter.book;

import org.springframework.stereotype.Component;

import demo.dto.book.PublisherDTO;
import demo.entity.book.PublisherEntity;

@Component
public class PublisherConverter {

	public PublisherEntity toEntity(PublisherDTO dto) {
		PublisherEntity entity = new PublisherEntity();
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		return entity;
	}
	
	public PublisherDTO toDTO(PublisherEntity entity) {
		PublisherDTO dto = new PublisherDTO();
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		return dto;
	}
	
	public PublisherEntity toEntity(PublisherDTO dto, PublisherEntity entity) {
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		return entity;
	}
}
