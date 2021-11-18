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
import demo.dto.book.AuthorDTO;
import demo.service.book.AuthorServiceImpl;

@CrossOrigin
@RestController
public class AuthorAPI {
	@Autowired
	private AuthorServiceImpl authorServiceImpl;
	
	@GetMapping(value = "/api/author")
	public BookOutput showAuthor(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			@RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		BookOutput result = new BookOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListAuthor(authorServiceImpl.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (authorServiceImpl.totalItem())/limit));
		return result;
	}
	@PostMapping(value = "/api/author")
	public AuthorDTO updateAuthorDTO(@RequestBody AuthorDTO modle) {
		return authorServiceImpl.save(modle);
	}
	
	@PutMapping(value = "/api/author/{id}")
	public AuthorDTO updateAuthorDTO(@RequestBody AuthorDTO modle, @PathVariable("id") long id) {
		modle.setId(id);
		return authorServiceImpl.save(modle);
	}
	@DeleteMapping(value = "/api/author")
	public void deleteAuthor(@RequestBody long[] ids) {
		authorServiceImpl.delete(ids);
	}
}
