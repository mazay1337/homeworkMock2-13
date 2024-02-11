package proskyhomework2v13mock.service;

import proskyhomework2v13mock.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String surName, int salary, int departmentId);

    Employee remove(String firstName, String surName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}