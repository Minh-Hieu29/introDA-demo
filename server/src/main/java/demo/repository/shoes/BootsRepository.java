package demo.repository.shoes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.shoes.BootsEntity;

public interface BootsRepository extends JpaRepository<BootsEntity, Long>{

}
