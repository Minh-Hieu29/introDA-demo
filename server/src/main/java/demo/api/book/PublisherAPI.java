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
import demo.dto.book.PublisherDTO;
import demo.service.book.PublisherServiceImpl;

@CrossOrigin
@RestController
public class PublisherAPI {

	@Autowired
	private PublisherServiceImpl publisherServiceImpl;
	
	@GetMapping(value = "/api/publisher")
	public BookOutput showPublisher(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
										@RequestParam(name="limit", required = false, defaultValue = "5") int limit,
										@RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		BookOutput result = new BookOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListPublisher(publisherServiceImpl.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (publisherServiceImpl.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/publisher")
	public PublisherDTO updatePublisherDTO(@RequestBody PublisherDTO model) {
		return publisherServiceImpl.save(model);
	}
	@PutMapping(value = "/api/publisher/{id}")
	public PublisherDTO updatePublisherDTO(@RequestBody PublisherDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return publisherServiceImpl.save(model);
	}
	@DeleteMapping(value = "/api/publisher")
	public void deletePublisher(@RequestBody long[] ids) {
		publisherServiceImpl.delete(ids);
	}
}
