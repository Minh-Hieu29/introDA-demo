package demo.service.electronic;

import demo.dto.electronic.ElectronicItemDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface ElectronicItemService {
    ElectronicItemDTO save(ElectronicItemDTO electronicItemDTO);
    void delete(long[] ids);
    List<ElectronicItemDTO> findAll(Pageable pageable);
    int totalItem();
}
