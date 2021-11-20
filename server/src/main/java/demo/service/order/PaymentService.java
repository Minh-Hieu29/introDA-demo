package demo.service.order;

import java.util.List;

import org.springframework.data.domain.Pageable;

import demo.dto.order.PaymentDTO;

public interface PaymentService {
	PaymentDTO save(PaymentDTO paymentDTO);
	void delete(long[] ids);
	List<PaymentDTO> findAll(Pageable pageable);
	int totalItem();
}
