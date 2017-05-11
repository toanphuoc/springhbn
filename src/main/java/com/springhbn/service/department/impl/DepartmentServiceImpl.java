package com.springhbn.service.department.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springhbn.dao.department.DepartmentDAO;
import com.springhbn.model.Department;
import com.springhbn.service.department.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDAO departmentDao;
	
	@Override
	@Transactional
	public List<Department> getAll() {
		return departmentDao.findAll();
	}

	@Override
	@Transactional
	public Department findById(int id) {
		return departmentDao.findById(id);
	}

	@Override
	@Transactional
	public int addDepartment(Department department) {
		return (int) departmentDao.save(department);
	}

	@Override
	@Transactional
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		
	}

}
