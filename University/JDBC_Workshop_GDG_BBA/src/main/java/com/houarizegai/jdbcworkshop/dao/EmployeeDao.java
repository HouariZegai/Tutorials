package com.houarizegai.jdbcworkshop.dao;

import com.houarizegai.jdbcworkshop.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
