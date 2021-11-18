package demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.book.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>{
	AuthorEntity findOneById(Long id);
}
