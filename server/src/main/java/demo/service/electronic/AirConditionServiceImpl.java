package demo.service.electronic;

import demo.converter.electronic.AirConditionConverter;
import demo.dto.electronic.AirConditionDTO;
import demo.dto.electronic.LaptopDTO;
import demo.entity.electronic.AirConditionEntity;
import demo.entity.electronic.LaptopEntity;
import demo.repository.electronic.AirConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Service
public class AirConditionServiceImpl implements AirConditionService {
    @Autowired
    private AirConditionRepository airConditionRepository;

    @Autowired
    private AirConditionConverter airConditionConverter;

    @Override
    public AirConditionDTO save(AirConditionDTO airConditionDTO) {
        AirConditionEntity airConditionEntity = new AirConditionEntity();
        if(airConditionDTO.getId() != 0) {
            AirConditionEntity oldAirConditionEntity = airConditionRepository.findById(airConditionDTO.getId()).get();
            airConditionEntity = airConditionConverter.toEntity(airConditionDTO, oldAirConditionEntity);
        } else {
            airConditionEntity = airConditionConverter.toEntity(airConditionDTO);
        }

        airConditionEntity = airConditionRepository.save(airConditionEntity);
        return airConditionConverter.toDTO(airConditionEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            airConditionRepository.deleteById(item);
        }
    }

    @Override
    public List<AirConditionDTO> findAll(Pageable pageable) {
        List<AirConditionDTO> results = new ArrayList<>();
        List<AirConditionEntity> entities = airConditionRepository.findAll(pageable).getContent();
        for(AirConditionEntity item: entities) {
            AirConditionDTO dto = airConditionConverter.toDTO(item);
            results.add(dto);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return 0;
    }
}
