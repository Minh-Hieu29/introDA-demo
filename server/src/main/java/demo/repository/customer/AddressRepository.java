package demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
