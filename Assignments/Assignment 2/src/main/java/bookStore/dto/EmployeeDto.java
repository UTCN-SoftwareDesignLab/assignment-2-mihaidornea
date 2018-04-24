package bookStore.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto {

    @NotNull
    @Size(min = 1)
    private String username;

    @NotNull
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "Please input a valid email")
    private String email;

    @NotNull
    @Pattern (regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain an uppercase letter, a special character and a number!")
    @Size (min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull
    @Pattern (regexp = "^Administrator{1}?|Employee{1}?$", message = "Please enter 'Administrator' or 'Employee'")
    private String role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
