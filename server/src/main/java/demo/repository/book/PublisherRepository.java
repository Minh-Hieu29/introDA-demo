package demo.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.book.PublisherEntity;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long>{
	PublisherEntity findOneById(long id);
}
