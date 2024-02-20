package org.example;


import interfaces.IDB;
import interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class UserRepository implements IUserRepository {
    private final IDB db;


    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStudent(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO student(name,surname,gender,address,email,phone) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setBoolean(3,user.isGender());
            st.setString(4, user.getAddress());
            st.setString(5, user.getEmail());
            st.setString(6, user.getPhone());

            st.execute();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            }catch (Exception es){
                es.printStackTrace();
            }
        }
        return false;
    }
    //String query = "select * from login where name='"+login.getName()+"' and password='"+login.getPassword()+"'";

    public boolean login(Login login){
        Connection con = null;
        try{
            con = db.getConnection();
            String query = "select * from login where name='"+login.getName()+"' and password='"+login.getPassword()+"'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            if(rs.next()){
                return true;
            }else{
                return false;

            }
        }catch (Exception en){
            en.printStackTrace();
        }
        return false;
    }
    public boolean deleteStudentById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "delete from student where id = '"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            }catch (Exception es){
                es.printStackTrace();
            }
        }
        return false;
    }

    public boolean Reg(Login login){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO login(name,password) VALUES(?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login.getName());
            st.setString(2, login.getPassword());

            st.execute();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            }catch (Exception es){
                es.printStackTrace();
            }
        }
        return false;
    }



    @Override
    public User getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,address,email,phone FROM student WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                User user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
               con.close();
            }catch (Exception es){
                es.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,address,email,phone FROM student";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while (rs.next()){
                User user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            }catch (Exception es){
                es.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean updateStudent(User user){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE student SET name=?, surname=?, gender=?, address=?, email=?, phone=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setBoolean(3, user.isGender());
            st.setString(4, user.getAddress());
            st.setString(5, user.getEmail());
            st.setString(6, user.getPhone());
            st.setInt(7,user.getStudentID());

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es){
                es.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public List<Integer> getGradesByUserId(int userId){
        List<Integer> grades = new ArrayList<>();
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT grade FROM grades WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int grade = rs.getInt("grade");
                grades.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return grades;
    }
}


