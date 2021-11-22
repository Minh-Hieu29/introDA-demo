package demo.repository.clothes;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.clothes.ShirtEntity;

public interface ShirtRepositoy extends JpaRepository<ShirtEntity, Long>{

}
