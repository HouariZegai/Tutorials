package com.houarizegai.jdbcworkshop;

import com.houarizegai.jdbcworkshop.dao.DBConnection;
import com.houarizegai.jdbcworkshop.dao.EmployeeDao;
import com.houarizegai.jdbcworkshop.dao.EmployeeDaoImpl;
import com.houarizegai.jdbcworkshop.model.Employee;
import com.houarizegai.jdbcworkshop.model.EmployeeBuilder;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
	
        Employee newEmployee = new EmployeeBuilder()
                .name("Houari")
                .gender(true)
                .salary(2000)
                .build();
        employeeDao.save(newEmployee); // Add new Employee

        Employee employee = new EmployeeBuilder()
                .id(1)
                .name("Mohamed")
                .gender(true)
                .salary(2000)
                .build();
        employeeDao.save(employee); // Edit existing Employee

        employeeDao.findAll().forEach(System.out::println); // Get all Employees from the database & print it

        employeeDao.deleteById(1); // Delete Employee by Id

	employeeDao.findAll().forEach(emp -> System.out.println(emp)); // Get all Employees from the database & print it (2nd way)

    }
}
