package online.store.repositories;

import online.store.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorRepository   extends JpaRepository<Author, Long> {

    Set<Author> findById(Author author);
}
