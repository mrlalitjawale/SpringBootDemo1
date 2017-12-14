package com.springboot.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	private List<Employee> emps = new ArrayList<>(Arrays.asList(
			new Employee(1, "Name11", "City11"),
			new Employee(2, "Name22", "City22"),
			new Employee(2, "Name12", "City12"),
			new Employee(3, "Name13", "City13")));
	
	public List<Employee> getAllEmployees()
	{
		return emps;
	}
	
	public Employee getEmployeeById(int id) {
		return emps.stream().filter(e -> e.getId()==id).findFirst().get();
	}
	
	public void addEmployee(Employee emp) {
		emps.add(emp);
	}

	public void updateEmployee(Employee emp, int id) {
		for (int i = 1; i <= emps.size(); i++) {
			if(emps.get(i).getId() == id)
			{
				emps.set(i, emp);
				return;
			}
		}
	}

	public void deleteEmployee(int id) {
		emps.removeIf(e -> e.getId() == id);
	}
}
