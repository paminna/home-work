package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/my_db";

    private final String USER = "admin";
    private final String PASS = "123";

    public CustomerH2Repository() {
        Connection conn = null;
        Statement stmt = null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Customer");
            while (res.next())
            {
                Customer customer = new Customer();
                customer.setEMail(res.getString("eMail"));
                customer.setName(res.getString("name"));
                customer.setId(res.getLong("id"));
                customers.add(customer);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean createCustomer(String name, String eMail) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Customer(name,eMail) VALUES (?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, eMail);
            preparedStatement.execute();
            conn.close();
            return true;
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean doesCustomerExist(String name) throws SQLException
    {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT name FROM Customer WHERE name = " + "'" + name + "'");
            if (res.first())
                return true;
        }
        return false;
    }

    public Customer findByEmail(String email) throws SQLException
    {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM Customer WHERE email = " + "'" + email + "'");
            while (res.next())
            {
                Customer customer = new Customer();
                long kek = res.getLong("id");
                customer.setId(kek);
                customer.setName(res.getString("name"));
                customer.setEMail(res.getString("email"));
                return customer;
            }
        }
        return null;
    }
}


