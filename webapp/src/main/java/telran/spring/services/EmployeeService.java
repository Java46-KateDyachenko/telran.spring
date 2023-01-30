package telran.spring.services;

import java.util.List;

import telran.spring.entities.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	void createEmployee(Employee empl);

	void deleteEmployee(long id);

	List<Employee> findBySalaryBetween(int salaryFrom, int salaryTo);

	List<Employee> findByAgeBetween(int ageFrom, int ageTo);

	List<Employee> getByMonth(int monthNumber);

	/*
	 * void addEmployee(Employee empl);
	 * 
	 * void updateEmployee(Employee empl);
	 * 
	 * void deleteEmployee(int id);
	 * 
	 * void employeesBySalary(int salaryFrom, int salaryTo);
	 * 
	 * void employeesByAge(int ageFrom, int ageTo);
	 * 
	 * void employeesByBirthMonth(int monthNumber);
	 */

}