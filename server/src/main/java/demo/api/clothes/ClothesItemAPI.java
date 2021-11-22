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

import demo.api.output.ClothesOutput;
import demo.dto.clothes.ClothesItemDTO;
import demo.service.clothes.ClothesItemService;

@CrossOrigin
@RestController
public class ClothesItemAPI {

	@Autowired
	private ClothesItemService ClothesItemService;
	
	@GetMapping(value = "/api/clothes-item")
	public ClothesOutput showClothesItem(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		ClothesOutput result = new ClothesOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListClothesItem(ClothesItemService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (ClothesItemService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/clothes-item")
	public ClothesItemDTO createClothesItem(@RequestBody ClothesItemDTO model) {
		return ClothesItemService.save(model);
	}
	
	@PutMapping(value = "/api/clothes-item/{id}")
	public ClothesItemDTO updateClothesItem(@RequestBody ClothesItemDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return ClothesItemService.save(model);
	}
	
	@DeleteMapping(value = "/api/clothes-item")
	public void deleteClothesItem(@RequestBody long[] ids) {
		ClothesItemService.delete(ids);
	}
}

