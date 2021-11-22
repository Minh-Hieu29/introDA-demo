package demo.repository.clothes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.clothes.ClothesEntity;

public interface ClothesRepositoy extends JpaRepository<ClothesEntity, Long>{
	ClothesEntity findOneById(long id);
}
