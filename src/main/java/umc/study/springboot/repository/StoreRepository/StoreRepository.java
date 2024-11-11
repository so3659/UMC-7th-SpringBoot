package umc.study.springboot.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
