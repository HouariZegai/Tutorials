package com.houarizegai.jdbccourse;

import com.houarizegai.jdbccourse.model.Employee;
import com.houarizegai.jdbccourse.dao.EmployeeDao;
import com.houarizegai.jdbccourse.dao.EmployeeDaoImpl;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee = Employee.builder()
                .name("Mohamed")
                .gender(true)
                .birthDate(new Date())
                .salary(2356d)
                .build();


        employeeDao.save(employee);
//        employeeDao.findAll().forEach(System.out::println);
//        Employee emp = employeeDao.findById(2);
//        System.out.println(emp);

        employeeDao.deleteById(1);

        System.out.println("Done!");
    }
}
