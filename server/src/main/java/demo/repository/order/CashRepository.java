package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.CartEntity;
import demo.entity.order.CashEntity;

public interface CashRepository extends JpaRepository<CashEntity, Long>{

}
