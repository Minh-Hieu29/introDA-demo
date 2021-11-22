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
import demo.dto.clothes.TrousersDTO;
import demo.service.clothes.TrousersService;

@CrossOrigin
@RestController
public class TrousersAPI {

	@Autowired
	private TrousersService TrousersService;
	
	@GetMapping(value = "/api/trousers")
	public ClothesOutput showTrousers(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		ClothesOutput result = new ClothesOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListTrousers(TrousersService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (TrousersService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/trousers")
	public TrousersDTO createTrousers(@RequestBody TrousersDTO model) {
		return TrousersService.save(model);
	}
	
	@PutMapping(value = "/api/trousers/{id}")
	public TrousersDTO updateTrousers(@RequestBody TrousersDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return TrousersService.save(model);
	}
	
	@DeleteMapping(value = "/api/trousers")
	public void deleteTrousers(@RequestBody long[] ids) {
		TrousersService.delete(ids);
	}
}

