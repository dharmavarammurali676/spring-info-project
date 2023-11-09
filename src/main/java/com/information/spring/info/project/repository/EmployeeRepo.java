package com.information.spring.info.project.repository;

import com.information.spring.info.project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
