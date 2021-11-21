package demo.service.electronic;

import demo.dto.electronic.LaptopDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface LaptopService {
    LaptopDTO save(LaptopDTO laptopDTO);
    void delete(long[] ids);
    List<LaptopDTO> findAll(Pageable pageable);
    int totalItem();
}
