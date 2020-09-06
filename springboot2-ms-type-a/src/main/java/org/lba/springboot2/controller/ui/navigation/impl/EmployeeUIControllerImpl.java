package org.lba.springboot2.controller.ui.navigation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.lba.springboot2.controller.ui.form.data.Country;
import org.lba.springboot2.controller.ui.form.data.Qualification;
import org.lba.springboot2.controller.ui.form.data.Technology;
import org.lba.springboot2.controller.ui.form.employee.EmployeeForm;
import org.lba.springboot2.controller.ui.navigation.EmployeeControllerUI;
import org.lba.springboot2.db.model.Employee;
import org.lba.springboot2.rest.service.EmployeeService;
import org.lba.springboot2.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee-ui")
public class EmployeeUIControllerImpl implements EmployeeControllerUI {

	static final Logger logger = Logger.getLogger(EmployeeUIControllerImpl.class); 

	@Autowired
	@Qualifier("employeeAppService")
	private EmployeeService employeeService;

	//C
	@GetMapping("/form")
	public String showForm(Model model) {

		model.addAttribute("employee", new EmployeeForm());

		/*Populate Country SelectBox*/
		List<Country> countryList = this.getCountries();
		model.addAttribute("countries", countryList);
		/**/
		List<Qualification> qualificationList = this.getQualifications();
		model.addAttribute("qualifications", qualificationList);
		/**/
		/**/
		List<Technology> technologyList = this.getTechnologies();
		model.addAttribute("technologies", technologyList);


		return "employeeForm";
	}


	@PostMapping("/submit")
	public String submitForm( @ModelAttribute("employee") @Valid EmployeeForm employeeForm, BindingResult bindingResult, Model model ) {

		logger.debug("Form: " + employeeForm.toString());
		JsonUtil.getJsonFormat(employeeForm);

		if (bindingResult.hasErrors()) {
			return "employeeForm";
		}



		return "redirect:all";
	}




	//R
	@GetMapping("/all")
	public String listEmployees(Model model) {

		List<Employee> employeeList = employeeService.findAll();

		model.addAttribute("employees", employeeList);

		return "employeeList";
	}

	//U
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {

		logger.debug("Update Form for employee with id: " + id);

		Optional<Employee> employee = employeeService.findById(id);

		if(employee.get()!=null) {
			model.addAttribute("employee", employee.get());
		}


		return "employeeUpdateForm";
	}

	@PostMapping("update/{id}")
	public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult result,
			Model model) {

		logger.debug("Update for employee with id: " + id);
		logger.debug("Update submit form data: " + employee.toString());
		Employee savedEmployee =employeeService.updateEmployeeById(id, employee);
		logger.debug("Updated employee on db: " + savedEmployee.toString());
		
		return "redirect:/employee-ui/all";
	}

	//D
	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable("id") long id, Model model) {

		logger.debug("Delete Employee with id: " + id);
		
		employeeService.deleteEmployeeById(id);
		
		
		return "redirect:/employee-ui/all";
	}
	//Utils
	private List<Country> getCountries() {

		List<Country> toReturn = new ArrayList<>();

		toReturn.add(new Country(1L, "IT", "Italy"));
		toReturn.add(new Country(2L, "UK", "England"));
		toReturn.add(new Country(3L, "GR", "Germany"));
		toReturn.add(new Country(4L, "US", "Usa"));
		toReturn.add(new Country(5L, "IN", "India"));
		toReturn.add(new Country(6L, "CH", "China"));

		return toReturn;
	}

	private List<Qualification> getQualifications() {

		List<Qualification> toReturn = new ArrayList<>();

		toReturn.add(new Qualification(1L, "DR", "Degree"));
		toReturn.add(new Qualification(2L, "MS", "Master"));
		toReturn.add(new Qualification(3L, "PMP-PMI", "Project Manager Professional"));
		toReturn.add(new Qualification(4L, "AG", "Agile"));
		toReturn.add(new Qualification(5L, "SM", "Scrum Master"));
		toReturn.add(new Qualification(6L, "PO", "Product Owner"));


		return toReturn;
	}

	private List<Technology> getTechnologies() {

		List<Technology> toReturn = new ArrayList<>();

		toReturn.add(new Technology(1L, "Angular", "Angular"));
		toReturn.add(new Technology(2L, "J2E", "JavaEE"));
		toReturn.add(new Technology(3L, "SpringBoot", "SpringBoot"));
		toReturn.add(new Technology(4L, "PHP", "PHP"));
		toReturn.add(new Technology(5L, "Android", "Android"));
		toReturn.add(new Technology(6L, "IOS", "Swift"));


		return toReturn;
	}
}
