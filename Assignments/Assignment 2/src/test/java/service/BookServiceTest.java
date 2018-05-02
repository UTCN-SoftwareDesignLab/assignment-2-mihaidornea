package service;

import bookStore.dto.BookDto;
import bookStore.dto.builder.BookDtoBuilder;
import bookStore.entity.Book;
import bookStore.entity.builder.BookBuilder;
import bookStore.repository.BookRepository;
import bookStore.service.BookService;
import bookStore.service.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.accessibility.AccessibleStateSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;

    @Before
    public void setup(){
        bookService = new BookServiceImpl(bookRepository);

        List<Book> bookList = new ArrayList<>();
        Book book = new BookBuilder()
                .setAuthor("Hagi")
                .setTitle("Fara Cuvinte")
                .setGenre("Gramatica")
                .setQuantity(1)
                .setIsbn("123")
                .setPrice(0.5f)
                .build();
        bookList.add(book);
        when(bookRepository.findByIsbn("123")).thenReturn(book);
        when(bookRepository.findAllByAuthor("Hagi")).thenReturn(bookList);
        when(bookRepository.findAllByTitle("Fara Cuvinte")).thenReturn(bookList);
        when(bookRepository.findAllByGenre("Gramatica")).thenReturn(bookList);
        when(bookRepository.findAllByQuantityEquals(0)).thenReturn(bookList);
        when(bookRepository.findAll()).thenReturn(bookList);
        when(bookRepository.save(book)).thenReturn(new Book());
    }


    @Test
    public void findByIsbnTest(){
        Assert.assertEquals(bookService.findByIsbn("123").getIsbn(), "123");
    }

    @Test
    public void findAllByTitleTest(){
        Assert.assertEquals(bookService.findAllByTitle("Fara Cuvinte").size(), 1);
    }

    @Test
    public void findAllByGenreTest(){
        Assert.assertEquals(bookService.findAllByGenre("Gramatica").size(), 1);
    }

    @Test
    public void findAllByAuthorTest(){
        Assert.assertEquals(bookService.findAllByAuthor("Hagi").size(), 1);
    }

    @Test
    public void findAllByQuantityTest(){
        Assert.assertEquals(bookService.findAllOutOfStock().size(), 1);
    }

    @Test
    public void createTest(){
        Assert.assertNotNull(bookService.create(new BookDto()));
    }
}