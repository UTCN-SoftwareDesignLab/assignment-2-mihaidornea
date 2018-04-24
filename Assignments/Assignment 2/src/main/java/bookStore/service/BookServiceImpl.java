package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.dto.builder.BookDtoBuilder;
import bookStore.entity.Book;
import bookStore.entity.builder.BookBuilder;
import bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto findByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        BookDto bookDto = new BookDtoBuilder()
                .setTitle(book.getTitle())
                .setAuthor(book.getAuthor())
                .setGenre(book.getGenre())
                .setPrice(book.getPrice())
                .setQuantity(book.getQuantity())
                .build();
        return bookDto;
    }

    @Override
    public List<BookDto> findAll() {

        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            BookDto bookDto = new BookDtoBuilder()
                    .setTitle(book.getTitle())
                    .setAuthor(book.getAuthor())
                    .setGenre(book.getGenre())
                    .setPrice(book.getPrice())
                    .setQuantity(book.getQuantity())
                    .build();
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public List<BookDto> findAllOutOfStock() {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAllByQuantityEquals(0);

        for (Book book : books) {
            BookDto bookDto = new BookDtoBuilder()
                    .setTitle(book.getTitle())
                    .setAuthor(book.getAuthor())
                    .setGenre(book.getGenre())
                    .setPrice(book.getPrice())
                    .setQuantity(book.getQuantity())
                    .build();
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public List<BookDto> findAllByTitle(String title) {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAllByTitle(title);

        for (Book book : books) {
            BookDto bookDto = new BookDtoBuilder()
                    .setTitle(book.getTitle())
                    .setAuthor(book.getAuthor())
                    .setGenre(book.getGenre())
                    .setPrice(book.getPrice())
                    .setQuantity(book.getQuantity())
                    .build();
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public List<BookDto> findAllByGenre(String genre) {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAllByGenre(genre);

        for (Book book : books) {
            BookDto bookDto = new BookDtoBuilder()
                    .setTitle(book.getTitle())
                    .setAuthor(book.getAuthor())
                    .setGenre(book.getGenre())
                    .setPrice(book.getPrice())
                    .setQuantity(book.getQuantity())
                    .build();
            bookDtos.add(bookDto);
        }
        return bookDtos;       }

    @Override
    public List<BookDto> findAllByAuthor(String author) {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAllByAuthor(author);

        for (Book book : books) {
            BookDto bookDto = new BookDtoBuilder()
                    .setTitle(book.getTitle())
                    .setAuthor(book.getAuthor())
                    .setGenre(book.getGenre())
                    .setPrice(book.getPrice())
                    .setQuantity(book.getQuantity())
                    .build();
            bookDtos.add(bookDto);
        }
        return bookDtos;       }

    @Override
    public void create(BookDto bookDto) {
        System.out.println(bookDto.getIsbn());
        Book book = new BookBuilder().setAuthor(bookDto.getAuthor())
                            .setTitle(bookDto.getTitle())
                            .setIsbn(bookDto.getIsbn())
                            .setQuantity(bookDto.getQuantity())
                            .setGenre(bookDto.getGenre())
                            .setPrice(bookDto.getPrice())
                            .build();
        bookRepository.save(book);
    }

    @Override
    public void delete(BookDto bookDto) {
        bookRepository.deleteByIsbn(bookDto.getIsbn());
    }

    @Override
    public void sell(BookDto bookDto, int quantity) {
        Book book = bookRepository.findByIsbn(bookDto.getIsbn());
        bookDto.setQuantity(book.getQuantity()-quantity);
        bookRepository.updateBookQuantity(bookDto.getQuantity(), bookDto.getIsbn());
    }

    @Override
    public void updatePrice(float price, BookDto bookDto) {
        bookDto.setPrice(price);
        bookRepository.updateBookPrice(bookDto.getPrice(), bookDto.getIsbn());
    }
}
