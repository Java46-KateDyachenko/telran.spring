package telran.spring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import telran.spring.entities.Employee;
import telran.spring.services.EmployeeService;

@RestController
@Slf4j
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeService.getEmployees();
		return list;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return "Employee id=" + id + " successfully deleted";
	}

	@PostMapping("/employees")
	public String createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return "Employee created";
	}

	@GetMapping("/employees/salary/{salaryFrom}/{salaryTo}")
	public List<Employee> getBySalaryBetween(@PathVariable int salaryFrom, @PathVariable int salaryTo) {
		List<Employee> list = employeeService.findBySalaryBetween(salaryFrom, salaryTo);
		return list;
	}

	@GetMapping("employees/age/{ageFrom}/{ageTo}")
	public List<Employee> getByAgeBetween(@PathVariable int ageFrom, @PathVariable int ageTo) {
		List<Employee> list = employeeService.findByAgeBetween(ageFrom, ageTo);
		return list;
	}

	@GetMapping("employees/month/{monthNumber}")
	public List<Employee> getByMonth(@PathVariable int monthNumber) {
		List<Employee> list = employeeService.getByMonth(monthNumber);
		return list;
	}

}
