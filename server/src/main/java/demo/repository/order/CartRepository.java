package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{
	CartEntity findOneById(int cartQuantity);
}
