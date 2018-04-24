package bookStore.service;

import bookStore.dto.EmployeeDto;
import bookStore.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {

    // Employee findById(long authorId);
     List<Employee> findAll();
    EmployeeDto findByUsername(String username);
    void create(EmployeeDto employeeDto);
    void delete(EmployeeDto employeeDto);
    void update(EmployeeDto employeeDto, String newUsername);
}
