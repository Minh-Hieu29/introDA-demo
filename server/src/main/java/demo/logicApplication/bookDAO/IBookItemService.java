package demo.logicApplication.bookDAO;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.model.dto.book.BookItemDTO;

public interface IBookItemService {
	BookItemDTO save(BookItemDTO bookItemDTO);
	void delete(long[] ids);
	List<BookItemDTO> findAll(Pageable pageable);
	int totalItem();
}
