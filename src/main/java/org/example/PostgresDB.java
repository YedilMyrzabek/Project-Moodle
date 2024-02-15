package org.example;

import interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:postgresql://localhost:1234/postgres";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con =  DriverManager.getConnection(connectionString, "postgres", "1234");
            return con;
        }catch (Exception es){
            System.out.println(es);
            return null;
        }
    }
}
