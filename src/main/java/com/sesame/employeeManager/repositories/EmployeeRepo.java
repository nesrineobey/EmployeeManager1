package com.sesame.employeeManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sesame.employeeManager.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{

	void deleteEmployeeById(long id);
	Optional<Employee> findEmployeeById(long id);

}
