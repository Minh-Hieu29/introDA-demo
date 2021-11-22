package demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.CustomerMemberEntity;

public interface CustomerMemberRepository extends JpaRepository<CustomerMemberEntity, Long>{
	
}
