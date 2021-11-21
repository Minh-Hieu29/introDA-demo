package demo.api.electronic;

import demo.api.Output;
import demo.dto.electronic.LaptopDTO;
import demo.dto.electronic.MobilePhoneDTO;
import demo.service.electronic.MobilePhoneService;
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
public class MobilePhoneAPI {
    @Autowired
    private MobilePhoneService mobilePhoneService;

    @GetMapping(value = "/api/mobile")
    public Output showLaptop(@RequestParam(name ="page", required = false, defaultValue = "0") int page,
                             @RequestParam(name="limit", required = false, defaultValue = "5") int limit,
                             @RequestParam(name="sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        sortable = Sort.by("id").ascending();
        Output result = new Output();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page, limit, sortable);
        result.setListMobilePhone(mobilePhoneService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (mobilePhoneService.totalItem())/limit));
        return result;
    }

    @PostMapping(value = "/api/mobile")
    public MobilePhoneDTO createLaptop(@RequestBody MobilePhoneDTO model) {
        return mobilePhoneService.save(model);
    }

    @PutMapping(value = "/api/mobile/{id}")
    public MobilePhoneDTO updateBoots(@RequestBody MobilePhoneDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return mobilePhoneService.save(model);
    }

    @DeleteMapping(value = "/api/mobile")
    public void deleteBoots(@RequestBody long[] ids) {
        mobilePhoneService.delete(ids);
    }
}
