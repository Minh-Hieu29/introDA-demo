package demo.converter.electronic;

import demo.dto.electronic.AirConditionDTO;
import demo.entity.electronic.AirConditionEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Component
public class AirConditionConverter {
    public AirConditionEntity toEntity(AirConditionDTO dto) {
        AirConditionEntity entity = new AirConditionEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setScreenSize(dto.getScreenSize());
        entity.setModel(dto.getModel());
        entity.setWattage(dto.getWattage());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

    public AirConditionEntity toEntity(AirConditionDTO dto, AirConditionEntity entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setScreenSize(dto.getScreenSize());
        entity.setModel(dto.getModel());
        entity.setWattage(dto.getWattage());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

    public AirConditionDTO toDTO(AirConditionEntity entity) {
        AirConditionDTO dto = new AirConditionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setScreenSize(entity.getScreenSize());
        dto.setModel(entity.getModel());
        dto.setWattage(entity.getWattage());
        dto.setImageUrl(entity.getImageUrl());
        return dto;
    }
}
