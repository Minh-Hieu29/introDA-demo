package demo.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.order.ShipmentConverter;
import demo.dto.order.ShipmentDTO;
import demo.entity.order.ShipmentEntity;
import demo.repository.order.ShipmentRepository;
import demo.service.order.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService{

	@Autowired
	private ShipmentRepository ShipmentRepository;
	
	@Autowired 
	private ShipmentConverter ShipmentConverter;

	@Override
	public ShipmentDTO save(ShipmentDTO ShipmentDTO) {
		ShipmentEntity ShipmentEntity = new ShipmentEntity();
		if(ShipmentEntity.getId() != 0) {
			ShipmentEntity oldShipmentEntity = ShipmentRepository.findById(ShipmentEntity.getId()).get();
			ShipmentEntity = ShipmentConverter.toEntity(ShipmentDTO, oldShipmentEntity);
		} else {
			ShipmentEntity = ShipmentConverter.toEntity(ShipmentDTO);
		}
		ShipmentEntity = ShipmentRepository.save(ShipmentEntity);
		return ShipmentConverter.toDTO(ShipmentEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			ShipmentRepository.deleteById(item);
		}
	}

	@Override
	public List<ShipmentDTO> findAll(Pageable pageable) {
		List<ShipmentDTO> results = new ArrayList<>();
		List<ShipmentEntity> entities = ShipmentRepository.findAll(pageable).getContent();
		for(ShipmentEntity item: entities) {
			ShipmentDTO ShipmentDTO = ShipmentConverter.toDTO(item);
			results.add(ShipmentDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
