package demo.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.converter.customer.CustomerMemberConverter;
import demo.dto.customer.CustomerMemberDTO;
import demo.entity.customer.AccountEntity;
import demo.entity.customer.AddressEntity;
import demo.entity.customer.CustomerMemberEntity;
import demo.entity.customer.FullNameEntity;
import demo.repository.customer.AccountRepository;
import demo.repository.customer.AddressRepository;
import demo.repository.customer.CustomerMemberRepository;
import demo.repository.customer.FullnameRepository;

@Service
public class CustomerMemberServiceImpl implements CustomerMemberService{

	@Autowired
	private CustomerMemberRepository customerMemberRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private FullnameRepository fullnameRepository;
	
	@Autowired
	private CustomerMemberConverter customerMemberConverter;
	


	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			customerMemberRepository.deleteById(item);
		}
		
	}

	@Override
	public List<CustomerMemberDTO> findAll(Pageable pageable) {
		List<CustomerMemberDTO> results = new ArrayList<>();
		List<CustomerMemberEntity> entities = customerMemberRepository.findAll(pageable).getContent();
		for(CustomerMemberEntity item: entities) {
			CustomerMemberDTO CustomerMemberDTO = customerMemberConverter.toDTO(item);
			results.add(CustomerMemberDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustomerMemberDTO save(CustomerMemberDTO CustomerMemberDTO) {
		CustomerMemberEntity CustomerMemberEntity = new CustomerMemberEntity();
		if(CustomerMemberDTO.getId() != 0) {
			CustomerMemberEntity oldCustomerMemberEntity = customerMemberRepository.findById(CustomerMemberDTO.getId()).get();
			CustomerMemberEntity = customerMemberConverter.toEntity(CustomerMemberDTO, oldCustomerMemberEntity);
		} else {
			CustomerMemberEntity = customerMemberConverter.toEntity(CustomerMemberDTO);
		}
		AccountEntity accountEntity = accountRepository.findOneById(CustomerMemberDTO.getAccountId());
		CustomerMemberEntity.setAccount(accountEntity);
		FullNameEntity fullNameEntity = fullnameRepository.findOneById(CustomerMemberDTO.getFullNameId());
		CustomerMemberEntity.setFullName(fullNameEntity);
//		AddressEntity addressEntity = addressRepository.findById(CustomerMemberDTO.getAddressId());
//		CustomerMemberEntity.setAddress(addressEntity);
		CustomerMemberEntity = customerMemberRepository.save(CustomerMemberEntity);
		return customerMemberConverter.toDTO(CustomerMemberEntity);
	}
	
}
