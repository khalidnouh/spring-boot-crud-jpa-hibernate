package com.springboot.crud.dao;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeDao {
public List<Employee>getEmployees();
public Employee getEmployee(int id);
public boolean saveEmployee(Employee employee);
public boolean deleteEmployee(Employee employee);

}
