package bookStore.dto.builder;

import bookStore.dto.BookDto;

public class BookDtoBuilder {

    private BookDto bookDto;

    public BookDtoBuilder(){
        bookDto = new BookDto();
    }

    public BookDtoBuilder setTitle(String title){
        bookDto.setTitle(title);
        return this;
    }

    public BookDtoBuilder setAuthor(String author){
        bookDto.setAuthor(author);
        return this;
    }

    public BookDtoBuilder setIsbn(String isbn){
        bookDto.setIsbn(isbn);
        return this;
    }

    public BookDtoBuilder setGenre(String genre){
        bookDto.setGenre(genre);
        return this;
    }

    public BookDtoBuilder setPrice(float price){
        bookDto.setPrice(price);
        return this;
    }

    public BookDtoBuilder setQuantity(int quantity){
        bookDto.setQuantity(quantity);
        return this;
    }

    public BookDto build(){
        return bookDto;
    }

}
