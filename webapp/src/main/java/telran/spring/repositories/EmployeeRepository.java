package telran.spring.repositories;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.spring.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findBySalaryBetween(int salaryFrom, int salaryTo);

	List<Employee> findByBirthDateBetween(Date dateFrom, Date dateTo);

	List<Employee> findByBirthDateLike(String string);



	

	
 
}