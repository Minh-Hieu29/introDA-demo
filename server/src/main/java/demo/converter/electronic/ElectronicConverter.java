package demo.converter.electronic;

import org.springframework.stereotype.Component;

import demo.dto.electronic.ElectronicDTO;
import demo.entity.electronic.ElectronicEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Component
public class ElectronicConverter {
    public ElectronicEntity toEntity(ElectronicDTO electronicDTO) {
        ElectronicEntity entity = new ElectronicEntity();
        entity.setId(electronicDTO.getId());
        entity.setName(electronicDTO.getName());
        entity.setBrand(electronicDTO.getBrand());
        entity.setScreenSize(electronicDTO.getScreenSize());
        entity.setModel(electronicDTO.getModel());
        entity.setImageUrl(electronicDTO.getImageUrl());
        return entity;
    }

    public ElectronicEntity toEntity(ElectronicDTO electronicDTO, ElectronicEntity entity) {
        entity.setId(electronicDTO.getId());
        entity.setName(electronicDTO.getName());
        entity.setBrand(electronicDTO.getBrand());
        entity.setScreenSize(electronicDTO.getScreenSize());
        entity.setModel(electronicDTO.getModel());
        entity.setImageUrl(electronicDTO.getImageUrl());
        return entity;
    }

    public ElectronicDTO toDTO(ElectronicEntity electronicEntity) {
        ElectronicDTO dto = new ElectronicDTO();
        dto.setId(electronicEntity.getId());
        dto.setName(electronicEntity.getName());
        dto.setBrand(electronicEntity.getBrand());
        dto.setScreenSize(electronicEntity.getScreenSize());
        dto.setModel(electronicEntity.getModel());
        dto.setImageUrl(electronicEntity.getImageUrl());
        return dto;
    }
}
