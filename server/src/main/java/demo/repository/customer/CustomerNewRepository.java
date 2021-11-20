package demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.CustomerNewEntity;

public interface CustomerNewRepository extends JpaRepository<CustomerNewEntity, Long>{

}
