package demo.repository.electronic;

import demo.entity.electronic.ElectronicItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface ElectronicItemRepository extends JpaRepository<ElectronicItemEntity, Long> {
}
