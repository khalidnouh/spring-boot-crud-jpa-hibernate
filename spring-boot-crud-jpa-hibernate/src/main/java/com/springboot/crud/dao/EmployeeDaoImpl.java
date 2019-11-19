package com.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.crud.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployees() {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session=entityManager.unwrap(Session.class);
		return session.get(Employee.class, id);
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		Session session=entityManager.unwrap(Session.class);
		session.delete(emp);
		return  true;
	}


}
