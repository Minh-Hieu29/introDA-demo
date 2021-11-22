package demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.customer.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	AccountEntity findOneById(long id);
}
