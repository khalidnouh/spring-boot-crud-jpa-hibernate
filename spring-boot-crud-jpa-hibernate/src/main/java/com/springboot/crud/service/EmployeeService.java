package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeService {
	public List<Employee>getEmployees();
	public Employee getEmployee(int id);
	public boolean saveEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);

}
