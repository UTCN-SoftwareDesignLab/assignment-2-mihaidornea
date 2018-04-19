package bookStore.entity.builder;

import bookStore.entity.Employee;

public class EmployeeBuilder {

    private Employee employee;

    public EmployeeBuilder() {
        this.employee = new Employee();
    }

    public EmployeeBuilder setUsername(String username){
        employee.setUsername(username);
        return this;
    }

    public EmployeeBuilder setPassword(String password){
        employee.setPassword(password);
        return this;
    }

    public EmployeeBuilder setRole(String role){
        employee.setRole(role);
        return this;
    }

    public EmployeeBuilder setEmail(String email){
        employee.setEmail(email);
        return this;
    }

    public Employee build(){
        return employee;
    }

}
