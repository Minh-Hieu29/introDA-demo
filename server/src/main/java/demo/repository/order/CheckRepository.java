package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.CartEntity;
import demo.entity.order.CheckEntity;

public interface CheckRepository extends JpaRepository<CheckEntity, Long>{

}
