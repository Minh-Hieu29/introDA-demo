package demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.entity.book.BookItemEntity;

public interface BookItemRepository extends JpaRepository<BookItemEntity, Long>{

}
