package demo.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.book.BookItemConverter;
import demo.dto.book.BookItemDTO;
import demo.entity.book.BookEntity;
import demo.entity.book.BookItemEntity;
import demo.repository.book.BookItemRepository;
import demo.repository.book.BookRepository;
import demo.service.book.BookItemServiceImpl;


@Service
public class BookItemService implements BookItemServiceImpl{

	@Autowired
	private BookItemRepository bookItemRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookItemConverter bookItemConverter;
	
	@Override
	public BookItemDTO save(BookItemDTO bookItemDTO) {
		BookItemEntity bookItemEntity = new BookItemEntity();
		if(bookItemDTO.getId() != 0) {
			BookItemEntity oldBookItemEntity = bookItemRepository.findById(bookItemDTO.getId()).get();
			bookItemEntity = bookItemConverter.toEntity(bookItemDTO, oldBookItemEntity);
		} else {
			bookItemEntity = bookItemConverter.toEntity(bookItemDTO);
		}
		BookEntity bookEntity = bookRepository.findOneByIsbn(bookItemDTO.getBookID());
		bookItemEntity.setBooks(bookEntity);
		bookItemEntity = bookItemRepository.save(bookItemEntity);
		return bookItemConverter.toDTO(bookItemEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			bookItemRepository.deleteById(item);
		}	
	}

	@Override
	public List<BookItemDTO> findAll(Pageable pageable) {
		List<BookItemDTO> results = new ArrayList<>();
		List<BookItemEntity> entities = bookItemRepository.findAll(pageable).getContent();
		for(BookItemEntity item: entities) {
			BookItemDTO bookItemDTO = bookItemConverter.toDTO(item);
			results.add(bookItemDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
