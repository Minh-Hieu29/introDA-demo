package demo.api.electronic;

import demo.api.Output;
import demo.dto.electronic.ElectronicItemDTO;
import demo.service.electronic.ElectronicItemService;
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
public class ElectronicItemAPI {

    @Autowired
    private ElectronicItemService electronicItemService;

    @GetMapping(value = "/api/electronic-item")
    public Output showElectronicItem(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
                                @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
                                @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        sortable = Sort.by("id").ascending();
        Output result = new Output();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page, limit, sortable);
        result.setListElectronicItem(electronicItemService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double)(electronicItemService.totalItem())/limit));
        return result;
    }

    @PostMapping(value = "/api/electronic-item")
    public ElectronicItemDTO createElectronicItem(@RequestBody ElectronicItemDTO model) {
        return electronicItemService.save(model);
    }

    @PutMapping(value = "/api/electronic-item/{id}")
    public ElectronicItemDTO updateElectronicItem(@RequestBody ElectronicItemDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return electronicItemService.save(model);
    }

    @DeleteMapping(value = "/api/electronic-item")
    public void deleteShoesItem(@RequestBody long[] ids) {
        electronicItemService.delete(ids);
    }
}
