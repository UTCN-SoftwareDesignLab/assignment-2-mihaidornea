package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.entity.Book;

import java.util.List;

public interface BookService {

    // Employee findById(long authorId);
    BookDto findByIsbn(String isbn);
    List<BookDto> findAll();
    List<BookDto> findAllOutOfStock();
    List<BookDto> findAllByTitle(String title);
    List<BookDto> findAllByGenre(String genre);
    List<BookDto> findAllByAuthor(String author);
    Book create(BookDto bookDto);
    void delete(BookDto bookDto);
    void sell(BookDto bookDto, int quantity);
    void updatePrice(float price, BookDto bookDto);


}
