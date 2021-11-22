package demo.repository.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{
//	AddressEntity findById(List<Long> id);
}
