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

import demo.api.output.BookItemOutput;
import demo.dto.book.BookItemDTO;
import demo.service.book.BookItemServiceImpl;




@CrossOrigin
@RestController()
public class BookItemAPI {

	@Autowired
	private BookItemServiceImpl bookItemService;
	
	@GetMapping(value = "/api/book-item")
	public BookItemOutput showBookItem(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
										@RequestParam(name="limit", required = false, defaultValue = "5") int limit,
										@RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		BookItemOutput result = new BookItemOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListBookItem(bookItemService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (bookItemService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/book-item")
	public BookItemDTO updateBookItem(@RequestBody BookItemDTO model) {
		return bookItemService.save(model);
	}
	
	@PutMapping(value = "/api/book-item/{id}")
	public BookItemDTO updateBookItem(@RequestBody BookItemDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return bookItemService.save(model);
	}
	
	@DeleteMapping(value = "/api/book-item")
	public void deleteBookItem(@RequestBody long[] ids) {
		bookItemService.delete(ids);
	}
	
}
