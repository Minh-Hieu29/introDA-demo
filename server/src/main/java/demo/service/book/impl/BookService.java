package demo.service.book.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.book.BookConverter;
import demo.dto.book.BookDTO;
import demo.entity.book.AuthorEntity;
import demo.entity.book.BookEntity;
import demo.entity.book.CategoryEntity;
import demo.entity.book.PublisherEntity;
import demo.repository.book.AuthorRepository;
import demo.repository.book.BookRepository;
import demo.repository.book.CategoryRepository;
import demo.repository.book.PublisherRepository;
import demo.service.book.BookServiceImpl;

@Service
public class BookService implements BookServiceImpl {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private BookConverter bookConverter;

	@Override
	public BookDTO save(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		if (bookDTO.getId() != 0) {
			BookEntity oldBookEntity = bookRepository.findById(bookDTO.getId()).get();
			bookEntity = bookConverter.toEntity(bookDTO, oldBookEntity);
		} else {
			bookEntity = bookConverter.toEntity(bookDTO);
		}
		AuthorEntity authorEntity = authorRepository.findOneById(bookDTO.getId());
		CategoryEntity categoryEntity = categoryRepository.findOneById(bookDTO.getId());
		PublisherEntity publisherEntity = publisherRepository.findOneById(bookDTO.getId());
		bookEntity.setPublisher(publisherEntity);
		bookEntity.setCategory(categoryEntity);
//		bookEntity.setAuthors(authorEntity);
		bookEntity = bookRepository.save(bookEntity);
		return bookConverter.toDTO(bookEntity);
		
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			bookRepository.deleteById(item);
		}

	}

	@Override
	public List<BookDTO> findAll(Pageable pageable) {
		List<BookDTO> results = new ArrayList<>();
		List<BookEntity> entities = bookRepository.findAll(pageable).getContent();
		for (BookEntity item : entities) {
			BookDTO bookDTO = bookConverter.toDTO(item);
			results.add(bookDTO);
		}
		return results;		
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
