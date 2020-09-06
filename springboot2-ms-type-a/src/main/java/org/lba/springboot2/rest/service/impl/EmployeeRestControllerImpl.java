package org.lba.springboot2.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.exception.EmployeeNotFoundException;
import org.lba.springboot2.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Qualifier("employeeRestService")
public class EmployeeRestControllerImpl implements EmployeeService {

	static final Logger logger = Logger.getLogger(EmployeeRestControllerImpl.class);

	@Autowired
	@Qualifier("employeeAppService")
	private EmployeeService employeeService;

	//C
	@Override
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.debug("Employee: " + employee.toString());
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return savedEmployee;
	}

	//R
	@Override
	@GetMapping("/all")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<Employee> findById(@PathVariable Long id) {

		Optional<Employee> queryResult = employeeService.findById(id);

		if(!queryResult.isPresent()) {
			throw new EmployeeNotFoundException(id);
		}
		return queryResult;
	}

	//U
	@Override
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(id, employee);
	}

	//D
	@Override
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable long id) {

		employeeService.deleteEmployeeById(id);

	}

}
