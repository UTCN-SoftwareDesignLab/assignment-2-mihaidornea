package bookStore.controller;

import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class BookFormController {

    BookService bookService;

    @Autowired
    public BookFormController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookCreateForm")
    public String createForm(BookDto bookDto){
        return "/bookCreateForm";
    }

    @PostMapping("/bookCreateForm")
    public String createBook(@Valid BookDto bookDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "/bookCreateForm";
        }
        bookService.create(bookDto);
        return "/success";
    }

    @GetMapping("/bookDeleteForm")
    public String deleteForm(BookDto bookDto){
        return "/bookDeleteForm";
    }

    @PostMapping("/bookDeleteForm")
    public String deleteBook(@Valid BookDto bookDto, BindingResult bindingResult){

        if(bindingResult.hasFieldErrors("isbn"))
            return "/bookDeleteForm";
        bookService.delete(bookDto);
        return "/success";
    }

    @GetMapping("/bookUpdateForm")
    public String updateForm(BookDto bookDto){
        return "/bookUpdateForm";
    }

    @PostMapping("/bookUpdateForm")
    public String updateBook(@Valid BookDto bookDto, BindingResult bindingResult){

        if (bindingResult.hasFieldErrors("isbn") || bindingResult.hasFieldErrors("price"))
            return "/bookUpdateForm";
        bookService.updatePrice(bookDto.getPrice(), bookDto);
        return "/success";
    }

    @GetMapping("/bookFindForm")
    public String findForm(BookDto bookDto){
        return "/bookFindForm";
    }

    @PostMapping("/bookFindForm")
    public ModelAndView findBook(@Valid BookDto bookDto, BindingResult bindingResult){

        if (bindingResult.hasFieldErrors("isbn")){
            ModelAndView mav = new ModelAndView("bookFindForm");
            return mav;
        }
        BookDto bookDto1 = bookService.findByIsbn(bookDto.getIsbn());
        ModelAndView mav = new ModelAndView("bookFound");
        mav.addObject("book", bookDto1);
        return mav;
    }

    @GetMapping("/bookSellForm")
    public String sellForm(BookDto bookDto){
        return "/bookSellForm";
    }

    @PostMapping("/bookSellForm")
    public String sellBook(@Valid BookDto bookDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors("isbn") || bindingResult.hasFieldErrors("quantity"))
            return "/bookSellForm";
        bookService.sell(bookDto, bookDto.getQuantity());
        return "/success";
    }

    @GetMapping("/bookFindByTitleForm")
    public String findByTitleForm(Model model){
        return "/bookFindByTitleForm";
    }

    @PostMapping("/bookFindByTitleForm")
    public ModelAndView findBooksByTitle(@RequestParam Map<String, String> field){
        List<BookDto> bookDto1 = bookService.findAllByTitle(field.get("title"));
        ModelAndView mav = new ModelAndView("bookFound");
        mav.addObject("book", bookDto1);
        return mav;
    }

    @GetMapping("/bookFindByGenreForm")
    public String findByGenreForm(Model model){
        return "/bookFindByGenreForm";
    }

    @PostMapping("/bookFindByGenreForm")
    public ModelAndView findBooksByGenre(@RequestParam Map<String, String> field){
        List<BookDto> bookDto1 = bookService.findAllByGenre(field.get("genre"));
        ModelAndView mav = new ModelAndView("bookFound");
        mav.addObject("book", bookDto1);
        return mav;
    }

    @GetMapping("/bookFindByAuthorForm")
    public String findByAuthorForm(Model model){
        return "/bookFindByAuthorForm";
    }

    @PostMapping("/bookFindByAuthorForm")
    public ModelAndView findBooksByAuthor(@RequestParam Map<String, String> field){
        List<BookDto> bookDto1 = bookService.findAllByAuthor(field.get("author"));
        ModelAndView mav = new ModelAndView("bookFound");
        mav.addObject("book", bookDto1);
        return mav;
    }


}





















