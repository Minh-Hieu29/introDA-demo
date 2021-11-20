package demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
//	CustomerEntity findOneByID(String id);
}
