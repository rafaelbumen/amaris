package com.amaris.backend.repository;

import com.amaris.backend.utils.Employee;
import java.util.List;

public interface IEmployeeRepository {
    List<Employee> fetchAllEmployees();
    Employee fetchEmployeeById(int id);
}
