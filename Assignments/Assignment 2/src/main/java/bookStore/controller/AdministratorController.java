package bookStore.controller;

import bookStore.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdministratorController {

    @GetMapping("/administrator")
    public String administratorController(Model model) {
        return "administrator";
    }

    @GetMapping("/goToForm")
    public String redirectCreateForm(Model model) {
        return "redirect:employeeCreateForm";
    }

    @GetMapping("/seeAllEmployees")
    public String seeAllEmployees(Model model) {
        return "redirect:allEmployees";
    }

    @GetMapping("/seeAllBooks")
    public String seeAllBooks(Model model){
        return "redirect:allBooks";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(Model model) {
        return "redirect:employeeDeleteForm";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(Model model) {
        return "redirect:employeeUpdateForm";
    }

    @GetMapping("/findEmployee")
    public String findEmployee(Model model) {
        return "redirect:employeeFindForm";
    }

    @GetMapping("/createBook")
    public String createBook(Model model) {
        return "redirect:bookCreateForm";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(Model model) {
        return "redirect:bookDeleteForm";
    }

    @GetMapping("/findBook")
    public String findBook(Model model) {
        return "redirect:bookFindForm";
    }

    @GetMapping("/updateBook")
    public String updateBook(Model model) {
        return "redirect:bookUpdateForm";
    }

    @GetMapping("/goHome")
    public String goHome(Model model) {
        return "redirect:administrator";
    }



}
