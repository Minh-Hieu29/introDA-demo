package demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.book.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{
	BookEntity findOneById(long id);
}
