package demo.service.electronic;

import demo.converter.electronic.MobilePhoneConverter;
import demo.dto.electronic.MobilePhoneDTO;
import demo.entity.electronic.MobilePhoneEntity;
import demo.repository.electronic.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @Autowired
    private MobilePhoneConverter mobilePhoneConverter;

    @Override
    public MobilePhoneDTO save(MobilePhoneDTO mobilePhoneDTO) {
        MobilePhoneEntity mobilePhoneEntity = new MobilePhoneEntity();
        if(mobilePhoneDTO.getId() != 0) {
            MobilePhoneEntity oldMobilePhoneEntity = mobilePhoneRepository.findById(mobilePhoneDTO.getId()).get();
            mobilePhoneEntity = mobilePhoneConverter.toEntity(mobilePhoneDTO, oldMobilePhoneEntity);
        } else {
            mobilePhoneEntity = mobilePhoneConverter.toEntity(mobilePhoneDTO);
        }

        mobilePhoneEntity = mobilePhoneRepository.save(mobilePhoneEntity);
        return mobilePhoneConverter.toDTO(mobilePhoneEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            mobilePhoneRepository.deleteById(item);
        }
    }

    @Override
    public List<MobilePhoneDTO> findAll(Pageable pageable) {
        List<MobilePhoneDTO> results = new ArrayList<>();
        List<MobilePhoneEntity> entities = mobilePhoneRepository.findAll(pageable).getContent();
        for(MobilePhoneEntity item: entities) {
            MobilePhoneDTO mobilePhoneDTO = mobilePhoneConverter.toDTO(item);
            results.add(mobilePhoneDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return 0;
    }
}
