package bookStore.repository;

import bookStore.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    void deleteByUsername(String username);

    Employee findByUsername(String username);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Employee e SET e.username = :newUsername WHERE e.email = :email")
    void updateUsername(@Param("newUsername") String newUsername, @Param("email") String email);

}
