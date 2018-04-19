package bookStore.controller;


import bookStore.entity.Employee;
import bookStore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
@Controller    // This means that this class is a Controller
public class MainController {


    EmployeeService employeeService;

    @Autowired
    public MainController(final EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Employee> getAllStudents() {
        // This returns a JSON or XML with the users
        return employeeService.findAll();
    }

    @GetMapping(path="/all1")
    public String getAllStudents1() {
        // This returns a JSON or XML with the users
        return "student_list";
    }


    @GetMapping("/todos")
    public String findAll(Model model)
    {
        final List<Employee> items=employeeService.findAll();
        model.addAttribute("itemsCount",items.size());

        return "home";
    }

    @RequestMapping(value = "/all2", method = RequestMethod.GET)
    public ModelAndView getAllStudents2()
    {
        List<Employee> studentDtoList = employeeService.findAll();

        ModelAndView mav = new ModelAndView("home");

        mav.addObject("studentDtoList", studentDtoList);

        return mav;
    }
}