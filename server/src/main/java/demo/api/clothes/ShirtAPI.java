package demo.api.clothes;

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
import demo.api.output.ClothesOutput;
import demo.dto.clothes.ShirtDTO;
import demo.dto.shoes.*;
import demo.service.clothes.ShirtService;

@CrossOrigin
@RestController
public class ShirtAPI {

	@Autowired
	private ShirtService ShirtService;
	
	@GetMapping(value = "/api/shirt")
	public ClothesOutput showShirt(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		ClothesOutput result = new ClothesOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListShirt(ShirtService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (ShirtService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/shirt")
	public ShirtDTO createShirt(@RequestBody ShirtDTO model) {
		return ShirtService.save(model);
	}
	
	@PutMapping(value = "/api/shirt/{id}")
	public ShirtDTO updateShirt(@RequestBody ShirtDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return ShirtService.save(model);
	}
	
	@DeleteMapping(value = "/api/shirt")
	public void deleteShirt(@RequestBody long[] ids) {
		ShirtService.delete(ids);
	}
}
