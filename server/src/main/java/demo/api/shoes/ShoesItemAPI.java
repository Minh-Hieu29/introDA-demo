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
import demo.dto.shoes.ShoesItemDTO;
import demo.service.shoes.ShoesItemService;

@CrossOrigin
@RestController
public class ShoesItemAPI {

	@Autowired
	private ShoesItemService shoesItemService;
	
	@GetMapping(value = "/api/shoes-item")
	public Output showShoesItem(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		Output result = new Output();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListShoesItem(shoesItemService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double)(shoesItemService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/shoes-item")
	public ShoesItemDTO createShoesItem(@RequestBody ShoesItemDTO model) {
		return shoesItemService.save(model);
	}
	
	@PutMapping(value = "/api/shoes-item/{id}")
	public ShoesItemDTO updateShoesItem(@RequestBody ShoesItemDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return shoesItemService.save(model);
	}
	
	@DeleteMapping(value = "/api/shoes-item")
	public void deleteShoesItem(@RequestBody long[] ids) {
		shoesItemService.delete(ids);
	}
}
