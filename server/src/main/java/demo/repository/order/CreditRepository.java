package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.CartEntity;
import demo.entity.order.CreditEntity;

public interface CreditRepository extends JpaRepository<CreditEntity, Long>{

}
