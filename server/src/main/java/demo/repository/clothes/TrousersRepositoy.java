package demo.repository.clothes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.clothes.TrousersEntity;

public interface TrousersRepositoy extends JpaRepository<TrousersEntity, Long>{

}
