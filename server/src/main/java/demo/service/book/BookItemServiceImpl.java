package demo.service.book;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.book.BookItemDTO;

public interface BookItemServiceImpl {
	BookItemDTO save(BookItemDTO bookItemDTO);
	void delete(long[] ids);
	List<BookItemDTO> findAll(Pageable pageable);
	int totalItem();
}
