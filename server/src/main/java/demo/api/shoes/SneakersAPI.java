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
import demo.dto.shoes.SneakersDTO;
import demo.service.shoes.SneakersService;

@CrossOrigin
@RestController
public class SneakersAPI {

	@Autowired
	private SneakersService SneakersService;
	
	@GetMapping(value = "/api/sneakers")
	public Output showSneakers(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
			 @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
			 @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
		sortable = Sort.by("id").ascending();
		Output result = new Output();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page, limit, sortable);
		result.setListSneakers(SneakersService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (SneakersService.totalItem())/limit));
		return result;
	}
	
	@PostMapping(value = "/api/sneakers")
	public SneakersDTO createSneakers(@RequestBody SneakersDTO model) {
		return SneakersService.save(model);
	}
	
	@PutMapping(value = "/api/sneakers/{id}")
	public SneakersDTO updateSneakers(@RequestBody SneakersDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return SneakersService.save(model);
	}
	
	@DeleteMapping(value = "/api/sneakers")
	public void deleteSneakers(@RequestBody long[] ids) {
		SneakersService.delete(ids);
	}
}
