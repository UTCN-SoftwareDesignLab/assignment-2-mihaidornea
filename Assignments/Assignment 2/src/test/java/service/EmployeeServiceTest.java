package service;

import bookStore.entity.Employee;
import bookStore.entity.builder.EmployeeBuilder;
import bookStore.repository.EmployeeRepository;
import bookStore.service.EmployeeService;
import bookStore.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Before
    public void setup(){
        employeeService = new EmployeeServiceImpl(employeeRepository);

        Employee employee = new EmployeeBuilder()
                .setEmail("mihai@test.com")
                .setUsername("mihaidornea")
                .setPassword("123A_3")
                .setRole("Administrator")
                .build();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        when(employeeRepository.findByUsername("mihaidornea")).thenReturn(employee);
        when(employeeRepository.findAll()).thenReturn(employeeList);
    }

    @Test
    public void findByUsernameTest(){
        Assert.assertNotNull(employeeService.findByUsername("mihaidornea"));
    }

    @Test
    public void findAllTest(){
        Assert.assertEquals(employeeService.findAll().size(), 1);
    }


}
