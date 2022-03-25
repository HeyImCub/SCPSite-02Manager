package com.cub.idk.service;

import com.cub.idk.model.Employee;
import com.cub.idk.model.SCPentity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    List <Employee> search(String keyword);

}
