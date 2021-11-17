package demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.book.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneById(long id);
}
