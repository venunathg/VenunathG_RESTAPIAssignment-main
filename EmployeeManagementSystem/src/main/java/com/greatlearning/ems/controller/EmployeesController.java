package com.greatlearning.ems.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.entity.Roles;
import com.greatlearning.ems.entity.User;
import com.greatlearning.ems.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// 2. Your application should be able to add Users in the db which can be used
	// for authentication purposes.

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return employeeService.saveUser(user);
	}

	// 1.Your application should be able to add roles in the database dynamically in
	// the db.

	@PostMapping("/role")
	public Roles saveRole(@RequestBody Roles role) {
		return employeeService.saveRole(role);
	}

	// 4. Your application should provide an endpoint to list all the employees
	// stored in the database.
	@GetMapping("/employees/employeesList")
	public List<Employee> findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findAll();
	}

	// 5. Your application should provide endpoint to fetch or get an employee
	// record specifically based on the id of that employee
	@GetMapping("/employees/{employee_id}")
	public Optional<Employee> getEmployee(@PathVariable int employee_id) {
		return employeeService.findById(employee_id);
	}

	// 3. Now Your application should be able to add employees data in the db if and
	// only if the authenticated user is ADMIN
	@PostMapping("/employees/add")
	public String addEmployee(@RequestBody Employee theEmployees) {
		return employeeService.save(theEmployees);

	}

	// 6. Your application should provide an endpoint to update an existing employee
	// record with the given updated json object

	@PutMapping("/employees/update")
	public String updateEmployee(@RequestBody Employee theEmployee) {
		return employeeService.updateEmployee(theEmployee);
	}

	// 7. Your application should also provide an endpoint to delete an existing
	// employee record based on the id of the employee
	@DeleteMapping("/employees/delete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		return employeeService.deleteById(employeeId);

	}

	// 8. Your application should provide an endpoint to fetch an employee by
	// his/her first name and if found more than one record then list them all

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstName(firstName);
	}

	// 9. Your application should be able to list all employee records sorted on
	// their first name in either ascending order or descending order
	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName(@RequestParam("order") String sortBy) {
		return employeeService.sortByFirstName(sortBy);
	}

}
