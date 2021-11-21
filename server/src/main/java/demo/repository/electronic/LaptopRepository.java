package demo.repository.electronic;

import demo.entity.electronic.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
}
