package com.amaris.backend.utils;

public class Employee {
    private int id;
    private String employeeName;
    private double employeeSalary;
    private int employeeAge;
    private String profileImage;

    public Employee(int id, String employeeName, double employeeSalary, int employeeAge, String profileImage) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }
}

