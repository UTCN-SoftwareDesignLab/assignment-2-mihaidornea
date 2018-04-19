package bookStore.service;

import bookStore.dto.EmployeeDto;
import bookStore.entity.Employee;
import bookStore.entity.builder.EmployeeBuilder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class CachingEmployeeService implements EmployeeService {

    private EmployeeService employeeService;

    public CachingEmployeeService( EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@Override
    //public Employee findById(long employeeId) {
    //   return employeeService.findById(employeeId);
    //}

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeService.findAll().forEach(employees::add);
        return employees;    }

    @Override
    public EmployeeDto findByUsername(String username) {
        return employeeService.findByUsername(username);
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
    }

    @Override
    public void delete(EmployeeDto employeeDto) {
        employeeService.delete(employeeDto);
    }

    @Override
    public void update(EmployeeDto employeeDto, String newUsername) {
        employeeService.update(employeeDto, newUsername);
    }
}
