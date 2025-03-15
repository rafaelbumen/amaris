package com.amaris.backend.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;
import com.amaris.backend.utils.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private final WebClient webClient;

    public EmployeeRepository(@Value("${api.employee.base-url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0")  
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        try {
            return webClient.get()
                    .uri("/employees")
                    .retrieve()
                    .bodyToFlux(Employee.class)
                    .collectList()
                    .block();
        } catch (WebClientResponseException e) {
            System.err.println("Error al consumir la API: " + e.getStatusCode());
            return List.of();
        }
    }

    @Override
    public Employee fetchEmployeeById(int id) {
        try {
            return webClient.get()
                    .uri("/employee/{id}", id)
                    .retrieve()
                    .bodyToMono(Employee.class)
                    .block();
        } catch (WebClientResponseException e) {
            System.err.println("Error al obtener empleado ID " + id + ": " + e.getStatusCode());
            return null;
        }
    }
}