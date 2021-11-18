package demo.service.book;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.book.CategoryDTO;

public interface CategoryServiceImpl {

	CategoryDTO save(CategoryDTO categoryDTO);
	void delete(long[] ids);
	List<CategoryDTO> findAll(Pageable pageable);
	int totalItem();
}
