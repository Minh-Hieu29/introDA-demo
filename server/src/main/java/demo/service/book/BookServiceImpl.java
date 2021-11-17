package demo.service.book;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.book.BookDTO;



public interface BookServiceImpl {
	BookDTO save(BookDTO bookDTO);
	void delete(long[] ids);
	List<BookDTO> findAll(Pageable pageable);
	int totalItem();
}
