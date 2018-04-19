package bookStore.dto.builder;

import bookStore.dto.EmployeeDto;

public class EmployeeDtoBuilder {

    EmployeeDto employeeDto;

    public EmployeeDtoBuilder() {
        this.employeeDto = new EmployeeDto();
    }

    public EmployeeDtoBuilder setEmail(String email){
        employeeDto.setEmail(email);
        return this;
    }

    public EmployeeDtoBuilder setUsername(String username){
        employeeDto.setUsername(username);
        return this;
    }

    public EmployeeDtoBuilder setRole(String role){
        employeeDto.setRole(role);
        return this;
    }

    public EmployeeDtoBuilder setPassword(String password){
        employeeDto.setPassword(password);
        return this;
    }

    public EmployeeDto build(){
        return employeeDto;
    }
    
}
