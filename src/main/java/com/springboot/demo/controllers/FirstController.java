package com.springboot.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Employee;
import com.springboot.demo.services.EmployeeService;

@RestController
public class FirstController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/firstMethod")
	public String firstMethod() {
		return "My first method called.";
	}
	
	@RequestMapping("/getAllEmp")
	public List<Employee> getAllEmp() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmpById/{eid}")
	public Employee getEmployeeById(@PathVariable("eid") int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addEmp")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateEmp/{id}")
	public void updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		employeeService.updateEmployee(emp, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteEmp/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
}
