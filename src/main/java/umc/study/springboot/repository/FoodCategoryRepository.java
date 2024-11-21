package umc.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
