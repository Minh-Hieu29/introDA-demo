package demo.service.book;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.book.PublisherDTO;

public interface PublisherServiceImpl {
	PublisherDTO save(PublisherDTO publisherDTO);
	void delete(long[] ids);
	List<PublisherDTO> findAll(Pageable pageable);
	int totalItem();
}
