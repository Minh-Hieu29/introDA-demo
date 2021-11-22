package demo.repository.clothes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.clothes.DressEntity;

public interface DressRepositoy extends JpaRepository<DressEntity, Long>{

}
