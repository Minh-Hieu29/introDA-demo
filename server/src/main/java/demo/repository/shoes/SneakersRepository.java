package demo.repository.shoes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.shoes.SneakersEntity;

public interface SneakersRepository extends JpaRepository<SneakersEntity, Long>{

}
