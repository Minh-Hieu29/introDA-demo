package demo.converter.electronic;

import org.springframework.stereotype.Component;

import demo.dto.electronic.ElectronicItemDTO;
import demo.entity.electronic.ElectronicItemEntity;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Component
public class ElectronicItemConverter {
    public ElectronicItemEntity toEntity(ElectronicItemDTO dto) {
        ElectronicItemEntity entity = new ElectronicItemEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setBarCode(dto.getBarCode());
        return entity;
    }

    public ElectronicItemEntity toEntity(ElectronicItemDTO dto, ElectronicItemEntity entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setBarCode(dto.getBarCode());
        return entity;
    }

    public ElectronicItemDTO toDTO(ElectronicItemEntity entity) {
        ElectronicItemDTO dto = new ElectronicItemDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDiscount(entity.getDiscount());
        dto.setBarCode(entity.getBarCode());
        return dto;
    }
}
