package telran.spring.services;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.spring.entities.Employee;
import telran.spring.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void createEmployee(Employee empl) {
		employeeRepository.save(empl);
	}

	@Override
	public void deleteEmployee(long id) {
			employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findBySalaryBetween(int salaryFrom, int salaryTo) {
		return employeeRepository.findBySalaryBetween(salaryFrom, salaryTo);
	}
	
	@Override
	public List<Employee> findByAgeBetween(int ageFrom, int ageTo){
		LocalDate LocalDateFrom = LocalDate.now().minusYears(ageTo);
		LocalDate LocalDateTo = LocalDate.now().minusYears(ageFrom);
		
		Date dateFrom = Date.from(LocalDateFrom.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date dateTo = Date.from(LocalDateTo.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		//System.out.println("DDDDDDDDDDDD"+dateFrom.toString()+" "+dateTo.toString());
	    // SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
	 	//return employeeRepository.findByBirthDateBetween(outputFormat.format(dateFrom),outputFormat.format(dateTo));
		return employeeRepository.findByBirthDateBetween(dateFrom,dateTo);
	} 

	@Override
	public List<Employee> getByMonth(int monthNumber){

	return employeeRepository.findByBirthDateLike("%."+String.format("%02d", monthNumber)+".%");
	}
}
