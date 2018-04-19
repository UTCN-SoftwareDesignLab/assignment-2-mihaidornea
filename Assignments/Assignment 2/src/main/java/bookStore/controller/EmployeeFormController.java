package bookStore.controller;

import bookStore.dto.EmployeeDto;
import bookStore.entity.Employee;
import bookStore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String creatingForm(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee", employeeDto);
        return "/employeeCreateForm";
    }

    @PostMapping("/employeeCreateForm")
    public String greetingSubmit(@ModelAttribute EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
        return "/success";
    }

    @GetMapping("/employeeDeleteForm")
    public String deleteForm(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee", employeeDto);
        return "/employeeDeleteForm";
    }

    @PostMapping("/employeeDeleteForm")
    public String deleteEmployee(@ModelAttribute EmployeeDto employeeDto) {
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

}