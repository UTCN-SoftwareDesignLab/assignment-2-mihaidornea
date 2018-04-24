package bookStore;

import bookStore.repository.EmployeeRepository;
import bookStore.service.CachingEmployeeService;
import bookStore.service.EmployeeService;
import bookStore.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "EmployeeService")
    public EmployeeService employeeService(EmployeeRepository employeeRepository){
        return new CachingEmployeeService(new EmployeeServiceImpl(employeeRepository));
    }

}
