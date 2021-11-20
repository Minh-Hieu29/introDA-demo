package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
