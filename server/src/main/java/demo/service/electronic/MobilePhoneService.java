package demo.service.electronic;

import demo.dto.electronic.MobilePhoneDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface MobilePhoneService {
    MobilePhoneDTO save(MobilePhoneDTO mobilePhoneDTO);
    void delete(long[] ids);
    List<MobilePhoneDTO> findAll(Pageable pageable);
    int totalItem();
}
