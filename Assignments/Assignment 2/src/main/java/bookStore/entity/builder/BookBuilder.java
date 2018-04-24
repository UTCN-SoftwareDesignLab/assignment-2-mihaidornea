package bookStore.entity.builder;

import bookStore.entity.Book;

public class BookBuilder {

    private Book book;

    public BookBuilder() {
        this.book = new Book();
    }

    public BookBuilder setTitle(String title){
        book.setTitle(title);
        return this;
    }

    public BookBuilder setAuthor(String author){
        book.setAuthor(author);
        return this;
    }

    public BookBuilder setIsbn(String isbn){
        book.setIsbn(isbn);
        return this;
    }

    public BookBuilder setQuantity(int quantity){
        book.setQuantity(quantity);
        return this;
    }

    public BookBuilder setGenre(String genre){
        book.setGenre(genre);
        return this;
    }

    public BookBuilder setPrice(float price){
        book.setPrice(price);
        return this;
    }

    public Book build(){
        return book;
    }

}
