package demo.repository.clothes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.clothes.ClothesItemEntity;

public interface ClothesItemRepositoy extends JpaRepository<ClothesItemEntity, Long>{

}
