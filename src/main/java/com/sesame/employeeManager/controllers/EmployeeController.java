package com.sesame.employeeManager.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.employeeManager.entities.Employee;
import com.sesame.employeeManager.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="*")
public class EmployeeController {
   private final EmployeeService employeeService;
   
   public EmployeeController( EmployeeService employeeService) {
	   this.employeeService=employeeService;
   }
   
   @GetMapping("/all")
   public ResponseEntity<List<Employee>> getAllEmployees(){
	  List<Employee> employees = employeeService.findAllEmployees();
	   return new ResponseEntity<>(employees, HttpStatus.OK);
   }
   
   @GetMapping("/find/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
	  Employee employee = employeeService.findEmployeeById(id);
	   return new ResponseEntity<>(employee, HttpStatus.OK);
   }
   
   @PostMapping("/add")
   public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
	   Employee newEmployee = employeeService.AddEmployee(employee);
	   return new ResponseEntity<>(newEmployee, HttpStatus.CREATED); 
	   
	   
   }
   @PutMapping("/update")
   public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
	   Employee updateEmployee = employeeService.updateEmployee(employee);
	   return new ResponseEntity<>(updateEmployee, HttpStatus.OK); 
	   
	   
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id){
	    employeeService.deleteEmployee(id);
	   return new ResponseEntity<>( HttpStatus.OK); 
	   
	   
   }
}
