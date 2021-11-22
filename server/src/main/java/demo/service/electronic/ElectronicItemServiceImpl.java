package demo.service.electronic;


import demo.converter.electronic.ElectronicItemConverter;
import demo.dto.electronic.ElectronicItemDTO;
import demo.entity.electronic.ElectronicEntity;
import demo.entity.electronic.ElectronicItemEntity;
import demo.repository.electronic.ElectronicItemRepository;
import demo.repository.electronic.ElectronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Service
public class ElectronicItemServiceImpl implements ElectronicItemService {
    @Autowired
    private ElectronicRepository electronicRepository;

    @Autowired
    private ElectronicItemRepository electronicItemRepository;

    @Autowired
    private ElectronicItemConverter electronicItemConverter;

    @Override
    public ElectronicItemDTO save(ElectronicItemDTO electronicItemDTO) {
        ElectronicItemEntity electronicItemEntity = new ElectronicItemEntity();
        if(electronicItemDTO.getId() != 0) {
            ElectronicItemEntity oldElectronicItemEntity = electronicItemRepository.findById(electronicItemDTO.getId()).get();
            electronicItemEntity = electronicItemConverter.toEntity(electronicItemDTO, oldElectronicItemEntity);
        } else {
            electronicItemEntity = electronicItemConverter.toEntity(electronicItemDTO);
        }
        ElectronicEntity electronicEntity = electronicRepository.findOneById(electronicItemDTO.getId());
        electronicItemEntity.setElectronicEntity(electronicEntity);
        electronicItemEntity = electronicItemRepository.save(electronicItemEntity);
        return electronicItemConverter.toDTO(electronicItemEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            electronicItemRepository.deleteById(item);
        }
    }

    @Override
    public List<ElectronicItemDTO> findAll(Pageable pageable) {
        List<ElectronicItemDTO> results = new ArrayList<>();
        List<ElectronicItemEntity> entities = electronicItemRepository.findAll(pageable).getContent();
        for(ElectronicItemEntity item: entities) {
            ElectronicItemDTO electronicItemDTO = electronicItemConverter.toDTO(item);
            results.add(electronicItemDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return 0;
    }
}
