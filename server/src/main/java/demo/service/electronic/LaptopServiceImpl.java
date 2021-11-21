package demo.service.electronic;

import demo.converter.electronic.LaptopConverter;
import demo.dto.electronic.LaptopDTO;
import demo.entity.electronic.LaptopEntity;
import demo.repository.electronic.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private LaptopConverter laptopConverter;

    @Override
    public LaptopDTO save(LaptopDTO laptopDTO) {
        LaptopEntity laptopEntity = new LaptopEntity();
        if(laptopDTO.getId() != 0) {
            LaptopEntity oldLaptopEntity = laptopRepository.findById(laptopDTO.getId()).get();
            laptopEntity = laptopConverter.toEntity(laptopDTO, oldLaptopEntity);
        } else {
            laptopEntity = laptopConverter.toEntity(laptopDTO);
        }

        laptopEntity = laptopRepository.save(laptopEntity);
        return laptopConverter.toDTO(laptopEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            laptopRepository.deleteById(item);
        }
    }

    @Override
    public List<LaptopDTO> findAll(Pageable pageable) {
        List<LaptopDTO> results = new ArrayList<>();
        List<LaptopEntity> entities = laptopRepository.findAll(pageable).getContent();
        for(LaptopEntity item: entities) {
            LaptopDTO dto = laptopConverter.toDTO(item);
            results.add(dto);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return 0;
    }
}
