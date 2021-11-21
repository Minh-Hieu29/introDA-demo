package demo.repository.electronic;

import demo.entity.electronic.ElectronicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface ElectronicRepository extends JpaRepository<ElectronicEntity, Long> {
    ElectronicEntity findOneById(Long id);
}
