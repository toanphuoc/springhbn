package com.springhbn.service.department;

import java.util.List;

import com.springhbn.model.Department;

public interface DepartmentService {

	public List<Department> getAll();
	public Department findById(int id);
	public int addDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(int id);
}
