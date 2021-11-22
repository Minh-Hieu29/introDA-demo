package demo.converter.electronic;

import demo.dto.electronic.MobilePhoneDTO;
import demo.entity.electronic.MobilePhoneEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Junkie on 21/11/2021.
 **/
@Component
public class MobilePhoneConverter {
    public MobilePhoneEntity toEntity(MobilePhoneDTO dto) {
        MobilePhoneEntity entity = new MobilePhoneEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setBrand(dto.getBrand());
        entity.setScreenSize(dto.getScreenSize());
        entity.setModel(dto.getModel());
        entity.setOrigin(dto.getOrigin());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setRam(dto.getRam());
        dto.setCreaterDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return entity;
    }

    public MobilePhoneEntity toEntity(MobilePhoneDTO dto, MobilePhoneEntity entity) {
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

    public MobilePhoneDTO toDTO(MobilePhoneEntity entity) {
        MobilePhoneDTO dto = new MobilePhoneDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBrand(entity.getBrand());
        dto.setScreenSize(entity.getScreenSize());
        dto.setModel(entity.getModel());
        dto.setOrigin(entity.getOrigin());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        dto.setRam(entity.getRam());
        return dto;
    }
}
