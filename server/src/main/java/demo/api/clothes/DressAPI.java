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
import demo.dto.clothes.DressDTO;
import demo.service.clothes.DressService;

@CrossOrigin
@RestController
public class DressAPI {

	@Autowired
	private DressService DressService;
	
	@GetMapping(value = "/api/dress")
	public ClothesOutput showDress(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		ClothesOutput result = new ClothesOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListDress(DressService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (DressService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/dress")
	public DressDTO createDress(@RequestBody DressDTO model) {
		return DressService.save(model);
	}
	
	@PutMapping(value = "/api/dress/{id}")
	public DressDTO updateDress(@RequestBody DressDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return DressService.save(model);
	}
	
	@DeleteMapping(value = "/api/dress")
	public void deleteDress(@RequestBody long[] ids) {
		DressService.delete(ids);
	}
}
