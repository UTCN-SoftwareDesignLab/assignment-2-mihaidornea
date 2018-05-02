package bookStore.controller;

import bookStore.dto.BookDto;
import bookStore.entity.Book;
import bookStore.report.CsvStrategy;
import bookStore.report.PdfStrategy;
import bookStore.service.BookService;
import bookStore.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.apache.tomcat.util.http.fileupload.IOUtils.copy;

@Controller
public class BookFormController {

    BookService bookService;
    ReportService reportService;

    @Autowired
    public BookFormController(BookService bookService, ReportService reportService) {
        this.bookService = bookService;
        this.reportService = reportService;
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

    @GetMapping("/generatePdfReport")
    public String generatePdfReport(Model model, HttpServletResponse response) throws IOException {
        List<BookDto> bookDtos = bookService.findAllOutOfStock();
        reportService.setReportStrategy(new PdfStrategy());
        try{
            InputStream inputStream = reportService.generateReport(bookDtos);
            copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex){
            return "/administrator";
        }
        return "/success";
    }

    @GetMapping("/generateCsvReport")
    public String generateCsvReport(Model model, HttpServletResponse response) throws IOException {
        List<BookDto> bookDtos = bookService.findAllOutOfStock();
        reportService.setReportStrategy(new CsvStrategy());
        try{
            InputStream inputStream = reportService.generateReport(bookDtos);
            copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex){
            return "/administrator";
        }
        return "/success";
    }

}





















