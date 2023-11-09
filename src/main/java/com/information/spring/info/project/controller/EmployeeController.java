package com.information.spring.info.project.controller;

import com.information.spring.info.project.entity.Employee;
import com.information.spring.info.project.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/save/employee/information")
    public ResponseEntity<String> saveEmployeeInfo(@RequestBody Employee employee) {
        Employee employeeDetails = employeeRepo.save(employee);
        if (employeeDetails != null) {
            return new ResponseEntity<>("Employee Information Saved in Database", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save employee details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/employees")
    public List<Employee> getAllEmployeesList() {
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }

    @GetMapping("/target/employee/{id}")
    public ResponseEntity<Employee> targetEmployee(@PathVariable long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/employee/{id}")
    public ResponseEntity<String> updateEmployeeInfo(@PathVariable long id, @RequestBody Employee employee) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setEmployeeFullName(employee.getEmployeeFullName());
            employeeOptional.get().setEmployeeEmail(employee.getEmployeeEmail());
            employeeOptional.get().setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
            employeeOptional.get().setEmployeePosition(employee.getEmployeePosition());
            employeeOptional.get().setEmployeeAddress(employee.getEmployeeAddress());
            Employee updatedEmployee = employeeRepo.save(employeeOptional.get());
            return new ResponseEntity<>("Updated Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()){
            employeeRepo.deleteById(id);
          return new ResponseEntity<>("Employee has been Deleted",HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
        }
    }
}

