package bookStore.controller;

import bookStore.dto.EmployeeDto;
import bookStore.entity.Employee;
import bookStore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeFormController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeFormController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employeeCreateForm")
    public String creatingForm(EmployeeDto employeeDto) {
        return "/employeeCreateForm";
    }

    @PostMapping("/employeeCreateForm")
    public String greetingSubmit(@Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/employeeCreateForm";
        employeeService.create(employeeDto);
        return "/success";
    }

    @GetMapping("/employeeDeleteForm")
    public String deleteForm(EmployeeDto employeeDto){
        return "/employeeDeleteForm";
    }

    @PostMapping("/employeeDeleteForm")
    public String deleteEmployee(@Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("username"))
            return "/employeeDeleteForm";
        employeeService.delete(employeeDto);
        return "/success";
    }

    @GetMapping("/employeeUpdateForm")
    public String updateForm(Model model) {
        return "/employeeUpdateForm";
    }

    @PostMapping("/employeeUpdateForm")
    public String updateEmployee(@RequestParam Map<String,String> fields) {
        EmployeeDto employeeDto = employeeService.findByUsername(fields.get("username"));
        employeeService.update(employeeDto, fields.get("newUsername"));
        return "/success";
    }

    @GetMapping("/employeeFindForm")
    public String findForm (Model model){
        return "/employeeFindForm";
    }

    @PostMapping("/employeeFindForm")
    public ModelAndView findEmployee(@RequestParam Map<String, String> field){
        EmployeeDto employeeDto = employeeService.findByUsername(field.get("username"));
        ModelAndView mav = new ModelAndView("employeeFound");
        mav.addObject("employee", employeeDto);
        return mav;
    }

}