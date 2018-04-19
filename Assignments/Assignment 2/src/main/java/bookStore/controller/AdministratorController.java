package bookStore.controller;

import bookStore.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdministratorController {

    @GetMapping("/administrator")
    public String administratorController(Model model){
        return "administrator";
    }

   @GetMapping("/goToForm")
    public String redirectCreateForm(Model model){
       return "redirect:employeeCreateForm";
   }

    @GetMapping("/seeAll")
    public String seeAllEmployees(Model model){
        return "redirect:all2";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(Model model){
        return "redirect:employeeDeleteForm";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(Model model){
        return "redirect:employeeUpdateForm";
    }

}
