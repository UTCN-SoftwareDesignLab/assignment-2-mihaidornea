package bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/regularUser")
    public String regularUserController(Model model) {
        return "regularUser";
    }

    @GetMapping("/sellBook")
    public String sellBook(Model model){
        return "redirect:bookSellForm";
    }


    @GetMapping("/goToFindByTitle")
    public String goToFindByTitle(Model model){
        return "bookFindByTitle";
    }

    @GetMapping("/goToFindByAuthor")
    public String goToFindByAuthor(Model model){
        return "bookFindByAuthor";
    }

    @GetMapping("/goToFindByGenre")
    public String goToFindByGenre(Model model){
        return "bookFindByGenre";
    }

    @GetMapping("/goHomeRegUser")
    public String goHomeRegularUser(Model model){
        return "regularUser";
    }

}
