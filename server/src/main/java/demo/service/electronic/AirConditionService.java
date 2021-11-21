package demo.service.electronic;

import demo.dto.electronic.AirConditionDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface AirConditionService {
    AirConditionDTO save(AirConditionDTO airConditionDTO);
    void delete(long[] ids);
    List<AirConditionDTO> findAll(Pageable pageable);
    int totalItem();
}
