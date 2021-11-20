package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.order.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	PaymentEntity findOneById(String paymentID);
}
