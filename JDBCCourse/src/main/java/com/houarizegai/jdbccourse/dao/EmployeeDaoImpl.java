package com.houarizegai.jdbccourse.dao;

import com.houarizegai.jdbccourse.model.Employee;
import com.houarizegai.jdbccourse.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return null;
        }

        List<Employee> employees = new LinkedList<>();

        String query = "SELECT * FROM employee;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Employee employee = Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birthDate(resultSet.getDate("birth_date"))
                        .salary(resultSet.getDouble("salary"))
                        .build();

                employees.add(employee);
            }

        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return null;
        }

        String query = "SELECT * FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birthDate(resultSet.getDate("birth_date"))
                        .salary(resultSet.getDouble("salary"))
                        .build();
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void save(Employee employee) {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return;
        }

        if(employee.getId() > 0) { // Update
            String query = "UPDATE employee SET name=?, gender=?, birth_date=?, salary=? WHERE id=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.isGender());
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setInt(5, employee.getId());

                preparedStatement.executeUpdate();
            } catch(SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } else { // Create
            String query = "INSERT INTO employee (name, gender, birth_date, salary) VALUES (?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.isGender());
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(4, employee.getSalary());

                preparedStatement.executeUpdate();
            } catch(SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteById(int id) {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return;
        }

        String query = "DELETE FROM employee WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
