package com.springhbn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springhbn.model.Department;
import com.springhbn.model.Employee;
import com.springhbn.service.department.DepartmentService;
import com.springhbn.service.employee.EmployeeService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/getAllDepartment", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Department> getAllDepartment() {
		return departmentService.getAll();
	}
	
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Employee> getAllEmployee() {
		return employeeService.getAll();
	}

	/*JSON for testing with POSTMAN
	 * {
			"name":"HR"
		}
	 */
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Department addDept(@RequestBody Department dept) {	
		int id = departmentService.addDepartment(dept);
		dept.setId(id);
		return dept;
	}
	
	/*
	 * {
		"name":"Nhan",
		"phone":"123"
		}
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee em) {
		int id = employeeService.add(em);
		em.setId(id);
		return em;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String testRequestParam(@RequestParam("name") String name){
		return name;
	}

}
