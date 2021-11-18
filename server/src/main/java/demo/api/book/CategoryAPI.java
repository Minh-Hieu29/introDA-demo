package demo.api.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.api.output.BookOutput;
import demo.dto.book.CategoryDTO;
import demo.service.book.CategoryServiceImpl;

@CrossOrigin
@RestController
public class CategoryAPI {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping(value = "/api/category")
	public BookOutput showCategory(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
										@RequestParam(name="limit", required = false, defaultValue = "5") int limit,
										@RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		BookOutput result = new BookOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListCategory(categoryServiceImpl.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(categoryServiceImpl.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/category")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO model) {
		return categoryServiceImpl.save(model);
	}
	
	@PutMapping(value = "/api/category/{id}")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO model, @PathVariable("id") long id ) {
		model.setId(id);
		return categoryServiceImpl.save(model);
	}
	
	@DeleteMapping(value = "api/category")
	public void deleteCategory(@RequestBody long[] ids) {
		categoryServiceImpl.delete(ids);
	}
}
