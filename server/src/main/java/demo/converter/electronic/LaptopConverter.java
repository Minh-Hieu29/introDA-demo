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
        entity.setOrigin(dto.getOrigin());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setRam(dto.getRam());
        return entity;
    }

    public LaptopEntity toEntity(LaptopDTO dto, LaptopEntity entity) {
    	entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setScreenSize(dto.getScreenSize());
        entity.setModel(dto.getModel());
        entity.setOrigin(dto.getOrigin());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setRam(dto.getRam());
        return entity;
    }

    public LaptopDTO toDTO(LaptopEntity entity) {
        LaptopDTO dto = new LaptopDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setScreenSize(entity.getScreenSize());
        dto.setModel(entity.getModel());
        dto.setOrigin(entity.getOrigin());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        dto.setRam(entity.getRam());
        dto.setCreaterDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }
}
