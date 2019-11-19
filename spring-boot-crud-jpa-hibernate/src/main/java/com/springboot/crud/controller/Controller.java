package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.dao.EmployeeDao;
import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;

@RestController
public class Controller {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> allEmps() {
		return employeeService.getEmployees();
	}

	@PostMapping("/employees")
	public boolean addEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	@GetMapping("/employees/{theId}")
	public Employee getEmployee(@PathVariable int theId) {
		return employeeService.getEmployee(theId);
	}
	
	@DeleteMapping("/employees/{theId}")
	public boolean deleteEmployee(@PathVariable int theId) {
		Employee emp=employeeService.getEmployee(theId);
		if(emp!=null)
		employeeService.deleteEmployee(emp);
		return true;
	}
}
