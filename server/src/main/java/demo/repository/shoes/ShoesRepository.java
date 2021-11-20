package demo.repository.shoes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.shoes.ShoesEntity;

public interface ShoesRepository extends JpaRepository<ShoesEntity, Long>{
	ShoesEntity findOneById(long id);
}
