package demo.service.customer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.customer.CustomerConverter;
import demo.dto.customer.CustomerDTO;
import demo.entity.customer.AccountEntity;
import demo.entity.customer.CustomerEntity;
import demo.entity.customer.FullNameEntity;
import demo.repository.customer.AccountRepository;
import demo.repository.customer.CustomerRepository;
import demo.repository.customer.FullnameRepository;
import demo.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private FullnameRepository fullnameRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		if(customerDTO.getId() != 0) {
			CustomerEntity oldCustomerEntity = customerRepository.findById(customerDTO.getId()).get();
			customerEntity = customerConverter.toEntity(customerDTO, oldCustomerEntity);
		} else {
			customerEntity = customerConverter.toEntity(customerDTO);
		}
		AccountEntity accountEntity = accountRepository.findOneByUsername(customerDTO.getAccountUsername());
		customerEntity.setAccount(accountEntity);
		FullNameEntity fullNameEntity = fullnameRepository.findOneByLastName(customerDTO.getFullnameLastname());
		customerEntity.setFullName(fullNameEntity);
		customerEntity = customerRepository.save(customerEntity);
		return customerConverter.toDTO(customerEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			customerRepository.deleteById(item);
		}
		
	}

	@Override
	public List<CustomerDTO> findAll(Pageable pageable) {
		List<CustomerDTO> results = new ArrayList<>();
		List<CustomerEntity> entities = customerRepository.findAll(pageable).getContent();
		for(CustomerEntity item: entities) {
			CustomerDTO customerDTO = customerConverter.toDTO(item);
			results.add(customerDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
