package demo.repository.electronic;

import demo.entity.electronic.MobilePhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Junkie on 21/11/2021.
 **/
public interface MobilePhoneRepository extends JpaRepository<MobilePhoneEntity, Long> {
}
