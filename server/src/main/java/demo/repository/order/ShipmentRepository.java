package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.ShipmentEntity;

public interface ShipmentRepository extends JpaRepository<ShipmentEntity, Long>{
	ShipmentEntity findOneById(String shipmentID);
}
