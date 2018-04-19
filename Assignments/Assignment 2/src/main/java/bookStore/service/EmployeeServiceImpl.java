package bookStore.service;

import bookStore.dto.EmployeeDto;
import bookStore.dto.builder.EmployeeDtoBuilder;
import bookStore.entity.Employee;
import bookStore.entity.builder.EmployeeBuilder;
import bookStore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*@Override
    public Employee findById(long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent())
            return optionalEmployee.get();
        else return null;
    }*/

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public EmployeeDto findByUsername(String username) {
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = employeeRepository.findByUsername(username);
        EmployeeDtoBuilder employeeDtoBuilder = new EmployeeDtoBuilder();
        employeeDto = employeeDtoBuilder.setEmail(employee.getEmail())
                .setUsername(employee.getUsername())
                .setPassword(employee.getPassword())
                .setRole(employee.getRole())
                .build();
        return employeeDto;
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Employee employee = employeeBuilder
                                .setPassword(employeeDto.getPassword())
                                .setUsername(employeeDto.getUsername())
                                .setRole(employeeDto.getRole())
                                .setEmail(employeeDto.getEmail())
                                .build();
        employeeRepository.save(employee);
    }

    @Override
    public void delete(EmployeeDto employeeDto) {
        employeeRepository.deleteByUsername(employeeDto.getUsername());
    }

    @Override
    public void update(EmployeeDto employeeDto, String newUsername) {
       Employee employee = employeeRepository.findByUsername(employeeDto.getUsername());
       employeeRepository.updateUsername(newUsername, employee.getEmail());
    }

}
