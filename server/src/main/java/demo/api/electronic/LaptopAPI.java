package demo.api.electronic;

import demo.api.Output;
import demo.dto.electronic.LaptopDTO;
import demo.service.electronic.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
@CrossOrigin
@RestController
public class LaptopAPI {
    @Autowired
    private LaptopService laptopService;

    @GetMapping(value = "/api/laptop")
    public Output showLaptop(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
                            @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
                            @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        sortable = Sort.by("id").ascending();
        Output result = new Output();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page, limit, sortable);
        result.setListLaptop(laptopService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (laptopService.totalItem())/limit));
        return result;
    }

    @PostMapping(value = "/api/laptop")
    public LaptopDTO createLaptop(@RequestBody LaptopDTO model) {
        return laptopService.save(model);
    }

    @PutMapping(value = "/api/laptop/{id}")
    public LaptopDTO updateBoots(@RequestBody LaptopDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return laptopService.save(model);
    }

    @DeleteMapping(value = "/api/laptop")
    public void deleteBoots(@RequestBody long[] ids) {
        laptopService.delete(ids);
    }
}
