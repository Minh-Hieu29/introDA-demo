package demo.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.customer.CustomerNewConverter;
import demo.dto.customer.CustomerNewDTO;
import demo.entity.customer.AccountEntity;
import demo.entity.customer.CustomerNewEntity;
import demo.entity.customer.FullNameEntity;
import demo.repository.customer.AccountRepository;
import demo.repository.customer.CustomerNewRepository;
import demo.repository.customer.FullnameRepository;

@Service
public class CustomerNewServiceImpl implements CustomerNewService{

	@Autowired
	private CustomerNewRepository customerNewRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private FullnameRepository fullnameRepository;
	
	@Autowired
	private CustomerNewConverter customerNewConverter;


	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			customerNewRepository.deleteById(item);
		}
		
	}

	@Override
	public List<CustomerNewDTO> findAll(Pageable pageable) {
		List<CustomerNewDTO> results = new ArrayList<>();
		List<CustomerNewEntity> entities = customerNewRepository.findAll(pageable).getContent();
		for(CustomerNewEntity item: entities) {
			CustomerNewDTO CustomerNewDTO = customerNewConverter.toDTO(item);
			results.add(CustomerNewDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustomerNewDTO save(CustomerNewDTO customerNewDTO) {
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		if(customerNewDTO.getId() != 0) {
			CustomerNewEntity oldCustomerNewEntity = customerNewRepository.findById(customerNewDTO.getId()).get();
			customerNewEntity = customerNewConverter.toEntity(customerNewDTO, oldCustomerNewEntity);
		} else {
			customerNewEntity = customerNewConverter.toEntity(customerNewDTO);
		}
		AccountEntity accountEntity = accountRepository.findOneById(customerNewDTO.getAccountId());
		customerNewEntity.setAccount(accountEntity);
		FullNameEntity fullNameEntity = fullnameRepository.findOneById(customerNewDTO.getFullNameId());
		customerNewEntity.setFullName(fullNameEntity);
		customerNewEntity = customerNewRepository.save(customerNewEntity);
		return customerNewConverter.toDTO(customerNewEntity);
	}
	
	

}
