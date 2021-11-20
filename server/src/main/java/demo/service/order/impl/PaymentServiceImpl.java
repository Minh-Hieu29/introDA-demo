package demo.service.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.order.PaymentConverter;
import demo.dto.order.PaymentDTO;
import demo.entity.order.PaymentEntity;
import demo.repository.order.PaymentRepository;
import demo.service.order.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired 
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentConverter paymentConverter;

	@Override
	public PaymentDTO save(PaymentDTO paymentDTO) {
		PaymentEntity paymentEntity = new PaymentEntity();
		if(paymentEntity.getId() != 0) {
			PaymentEntity oldPaymentEntity = paymentRepository.findById(paymentEntity.getId()).get();
			paymentEntity = paymentConverter.toEntity(paymentDTO, oldPaymentEntity);
		} else {
			paymentEntity = paymentConverter.toEntity(paymentDTO);
		}
		paymentEntity = paymentRepository.save(paymentEntity);
		return paymentConverter.toDTO(paymentEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			paymentRepository.deleteById(item);
		}
	}

	@Override
	public List<PaymentDTO> findAll(Pageable pageable) {
		List<PaymentDTO> results = new ArrayList<>();
		List<PaymentEntity> entities = paymentRepository.findAll(pageable).getContent();
		for(PaymentEntity item: entities) {
			PaymentDTO PaymentDTO = paymentConverter.toDTO(item);
			results.add(PaymentDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
