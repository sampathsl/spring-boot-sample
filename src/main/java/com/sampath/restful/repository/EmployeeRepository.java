package com.sampath.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampath.restful.model.Employee;
/**
 * 
 * @author SAMPATH
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
