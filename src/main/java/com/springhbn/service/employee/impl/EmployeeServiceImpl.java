package com.springhbn.service.employee.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springhbn.dao.department.DepartmentDAO;
import com.springhbn.dao.employee.EmployeeDAO;
import com.springhbn.model.Department;
import com.springhbn.model.Employee;
import com.springhbn.service.employee.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Autowired 
	private DepartmentDAO departmentDao;
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int add(Employee employee) {
		Department dp = departmentDao.findById(1);
		employee.setDepartment(dp);
		return (int) employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
