package demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.FullNameEntity;

public interface FullnameRepository extends JpaRepository<FullNameEntity, Long>{
 FullNameEntity findOneByLastName(String lastName);
}
