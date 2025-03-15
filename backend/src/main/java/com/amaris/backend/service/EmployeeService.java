package com.amaris.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.amaris.backend.utils.MockData;
import com.amaris.backend.repository.IEmployeeRepository;
import com.amaris.backend.utils.Employee;

@Service
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.fetchAllEmployees();
        return employees.isEmpty() ? MockData.getMockEmployees() : employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.fetchEmployeeById(id);
        return employee != null ? employee
                : MockData.getMockEmployees().stream()
                        .filter(emp -> emp.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    public double calculateAnnualSalary(double salary) {
        return salary * 12;
    }

}
