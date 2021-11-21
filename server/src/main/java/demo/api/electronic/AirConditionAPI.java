package demo.api.electronic;

import demo.api.Output;
import demo.dto.electronic.AirConditionDTO;
import demo.service.electronic.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Junkie on 21/11/2021.
 **/
@CrossOrigin
@RestController
public class AirConditionAPI {
    @Autowired
    private AirConditionService airConditionService;

    @GetMapping(value = "/api/air-condition")
    public Output showLaptop(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
                             @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
                             @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        sortable = Sort.by("id").ascending();
        Output result = new Output();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page, limit, sortable);
        result.setListAirCondition(airConditionService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (airConditionService.totalItem())/limit));
        return result;
    }

    @PostMapping(value = "/api/air-condition")
    public AirConditionDTO createLaptop(@RequestBody AirConditionDTO model) {
        return airConditionService.save(model);
    }

    @PutMapping(value = "/api/air-condition{id}")
    public AirConditionDTO updateBoots(@RequestBody AirConditionDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return airConditionService.save(model);
    }

    @DeleteMapping(value = "/api/air-condition")
    public void deleteBoots(@RequestBody long[] ids) {
        airConditionService.delete(ids);
    }
}
