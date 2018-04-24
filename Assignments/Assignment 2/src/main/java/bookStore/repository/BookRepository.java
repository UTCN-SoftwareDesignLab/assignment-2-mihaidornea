package bookStore.repository;

import bookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    void deleteByIsbn(String isbn);
    Book findByIsbn(String isbn);
    List<Book>findAllByQuantityEquals(int quantity);
    List<Book> findAllByTitle(String title);
    List<Book> findAllByGenre(String genre);
    List<Book> findAllByAuthor(String author);
    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.quantity = :newQuantity WHERE b.isbn = :isbn")
    void updateBookQuantity (@Param("newQuantity") int newQuantity, @Param("isbn") String isbn);
    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.price = :newPrice WHERE b.isbn = :isbn")
    void updateBookPrice (@Param("newPrice") float newPrice, @Param("isbn") String isbn);
}
