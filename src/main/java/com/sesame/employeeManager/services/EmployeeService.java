package com.sesame.employeeManager.services;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.employeeManager.entities.Employee;
import com.sesame.employeeManager.exceptions.UserNotFoundException;
import com.sesame.employeeManager.repositories.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {

		this.employeeRepo = employeeRepo;
	}

	public Employee AddEmployee(Employee employee) {
		employee.setEmpolyeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);

	}

	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();

	}

	public Employee updateEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	public Employee findEmployeeById(long id)  {
		return  employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("user by id " + id + "was not found"));
	}

	public void deleteEmployee(long id) {
		employeeRepo.deleteEmployeeById(id);
	}
}
