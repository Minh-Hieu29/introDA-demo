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
import demo.dto.book.BookDTO;
import demo.service.book.BookServiceImpl;

@CrossOrigin
@RestController()
public class BookAPI {

	@Autowired
	private BookServiceImpl BookService;
	
	@GetMapping(value = "/api/book")
	public BookOutput showBook(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
										@RequestParam(name="limit", required = false, defaultValue = "5") int limit,
										@RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		BookOutput result = new BookOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListResult(BookService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (BookService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/book")
	public BookDTO updateBook(@RequestBody BookDTO model) {
		return BookService.save(model);
	}
	
	@PutMapping(value = "/api/book/{id}")
	public BookDTO updateBook(@RequestBody BookDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return BookService.save(model);
	}
	
	@DeleteMapping(value = "/api/book")
	public void deleteBook(@RequestBody long[] ids) {
		BookService.delete(ids);
	}
	
}

