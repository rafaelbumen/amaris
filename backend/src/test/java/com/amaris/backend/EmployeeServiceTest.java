package com.amaris.backend;

import com.amaris.backend.repository.IEmployeeRepository;
import com.amaris.backend.service.EmployeeService;
import com.amaris.backend.utils.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock  // Mockeamos la capa de repositorio para evitar llamadas reales a la API
    private IEmployeeRepository employeeRepository;

    @InjectMocks  // Inyectamos el mock en la clase a probar
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepository); // Asegurar que usa el mock
    }

    @Test
    void testGetAllEmployees_ReturnsEmployeeList() {
        // 1️⃣ Simulamos datos de prueba con exactamente 2 empleados
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "John Doe", 50000, 25, ""),
                new Employee(2, "Jane Smith", 60000, 30, "")
        );
    
        // 2️⃣ Configuramos el comportamiento del mock para devolver la lista
        when(employeeRepository.fetchAllEmployees()).thenReturn(mockEmployees);
    
        // 3️⃣ Ejecutamos el método a probar
        List<Employee> result = employeeService.getAllEmployees();
    
        // 4️⃣ Validamos los resultados esperados
        assertNotNull(result);
        assertEquals(2, result.size());  // Aquí corregimos, deben ser 2 empleados
        assertEquals("John Doe", result.get(0).getEmployeeName());  // Validamos el primero
    
        // 5️⃣ Verificamos que el método del repositorio fue llamado exactamente una vez
        verify(employeeRepository, times(1)).fetchAllEmployees();
    }
    
}
