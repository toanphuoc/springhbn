package com.springhbn.service.employee;

import java.util.List;

import com.springhbn.model.Employee;

public interface EmployeeService {

	public List<Employee> getAll();
	public Employee findById(int id);
	public int add(Employee employee);
	public void update(Employee employee);
	public void delete(int id);
}
