package com.houarizegai.jdbcworkshop.dao;

import com.houarizegai.jdbcworkshop.model.Employee;
import com.houarizegai.jdbcworkshop.model.EmployeeBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

public class EmployeeDaoImpl implements EmployeeDao {
    public List<Employee> findAll() {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return null;
        }

        List<Employee> employees = new LinkedList<>();

        String sql = "SELECT id, name, gender, salary FROM employee;";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            ResultSet rs = prest.executeQuery();
            while(rs.next()) {
                Employee employee = new EmployeeBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .gender(rs.getBoolean("gender"))
                        .salary(rs.getDouble("salary"))
                        .build();

                employees.add(employee);
            }

        } catch(SQLException se) {
            se.printStackTrace();
        }

        return employees;
    }

    public Employee findById(int id) {
        Connection con = DBConnection.getConnection();
        if(con == null)
            return null;

        String sql = "SELECT id, name, gender, salary FROM employee WHERE id=?;";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, id);
            ResultSet rs = prest.executeQuery();
            if(rs.next()) {
                return new EmployeeBuilder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .gender(rs.getBoolean("gender"))
                        .salary(rs.getDouble("salary"))
                        .build();
            }

        } catch(SQLException se) {
            se.printStackTrace();
        }

        return null;
    }

    public void save(Employee employee) {
        Connection con = DBConnection.getConnection();
        if(con == null)
            return;

        if(employee.getId() > 0) { // Update employee
            String sql = "UPDATE employee SET name=?, gender=?, salary=? WHERE id=?;";
            try {
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, employee.getName());
                prest.setBoolean(2, employee.isGender());
                prest.setDouble(3, employee.getSalary());
                prest.setInt(4, employee.getId());
                prest.executeUpdate();
            } catch(SQLException se) {
                se.printStackTrace();
            }

        } else { // Create new Employee
            String sql = "INSERT INTO employee(name, gender, salary) VALUES(?, ?, ?);";
            try {
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, employee.getName());
                prest.setBoolean(2, employee.isGender());
                prest.setDouble(3, employee.getSalary());
                prest.executeUpdate();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public void deleteById(int id) {
        Connection con = DBConnection.getConnection();
        if(con == null)
            return;

        String sql = "DELETE FROM employee WHERE id=?;";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, id);
            prest.executeUpdate();
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
