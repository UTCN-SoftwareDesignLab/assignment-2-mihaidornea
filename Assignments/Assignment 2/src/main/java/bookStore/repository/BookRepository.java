package bookStore.repository;

import bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    void deleteByIsbn(String isbn);
    List<Book> findAllByTitle(String title);

}
