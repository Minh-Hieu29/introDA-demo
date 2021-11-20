package demo.repository.shoes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.shoes.ShoesItemEntity;

public interface ShoesItemRepository extends JpaRepository<ShoesItemEntity, Long>{

}
