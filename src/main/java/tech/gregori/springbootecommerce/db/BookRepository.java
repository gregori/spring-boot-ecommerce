package tech.gregori.springbootecommerce.db;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.gregori.springbootecommerce.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
