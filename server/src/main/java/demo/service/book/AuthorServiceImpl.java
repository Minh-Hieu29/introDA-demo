package demo.service.book;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.book.AuthorDTO;

public interface AuthorServiceImpl {
	AuthorDTO save(AuthorDTO AuthorDTO);
	void delete(long[] ids);
	List<AuthorDTO> findAll(Pageable pageable);
	int totalItem();
}
