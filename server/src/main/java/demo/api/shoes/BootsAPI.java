package demo.api.shoes;

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

import demo.api.Output;
import demo.dto.shoes.*;
import demo.service.shoes.BootsService;

@CrossOrigin
@RestController
public class BootsAPI {

	@Autowired
	private BootsService bootsService;
	
	@GetMapping(value = "/api/boots")
	public Output showBoots(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		Output result = new Output();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListBoots(bootsService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (bootsService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/boots")
	public BootsDTO createBoots(@RequestBody BootsDTO model) {
		return bootsService.save(model);
	}
	
	@PutMapping(value = "/api/boots/{id}")
	public BootsDTO updateBoots(@RequestBody BootsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return bootsService.save(model);
	}
	
	@DeleteMapping(value = "/api/boots")
	public void deleteBoots(@RequestBody long[] ids) {
		bootsService.delete(ids);
	}
}
