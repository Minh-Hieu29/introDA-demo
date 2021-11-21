package demo.converter.electronic;

import demo.dto.electronic.LaptopDTO;
import demo.entity.electronic.LaptopEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Component
public class LaptopConverter {
    public LaptopEntity toEntity(LaptopDTO dto) {
        LaptopEntity entity = new LaptopEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setScreenSize(dto.getScreenSize());
        entity.setModel(dto.getModel());
        entity.setWeight(dto.getWeight());
        entity.setWindowsVersion(dto.getWindowsVersion());
        return entity;
    }

    public LaptopEntity toEntity(LaptopDTO dto, LaptopEntity entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setScreenSize(dto.getScreenSize());
        entity.setModel(dto.getModel());
        entity.setWeight(dto.getWeight());
        entity.setWindowsVersion(dto.getWindowsVersion());
        return entity;
    }

    public LaptopDTO toDTO(LaptopEntity entity) {
        LaptopDTO dto = new LaptopDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setScreenSize(entity.getScreenSize());
        dto.setModel(entity.getModel());
        dto.setWeight(entity.getWeight());
        dto.setWindowsVersion(entity.getWindowsVersion());
        return dto;
    }
}
