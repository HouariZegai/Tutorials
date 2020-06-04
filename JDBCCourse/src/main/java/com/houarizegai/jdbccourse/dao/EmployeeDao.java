package com.houarizegai.jdbccourse.dao;

import com.houarizegai.jdbccourse.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
