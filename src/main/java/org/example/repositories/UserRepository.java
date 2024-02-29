package org.example.repositories;

import interfaces.IDB;
import interfaces.IUserRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.controllers.LoginController;
import org.example.models.Login;
import org.example.models.Subject;
import org.example.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
@Data

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStudent(User user, int id) {
        try (Connection con = db.getConnection()){
            String sql = "UPDATE student SET name = ?, surname = ?, gender = ?,address = ?,email = ?, phone = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setBoolean(3,user.isGender());
            st.setString(4, user.getAddress());
            st.setString(5, user.getEmail());
            st.setString(6, user.getPhone());
            st.setInt(7,id);

            st.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error in createStudent()");
        }
        return false;
    }

    public boolean login(Login login){
        try (Connection con = db.getConnection()){
            String query = "select * from login where name='"+login.getName()+"' and password='"+login.getPassword()+"'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            return rs.next();
        }catch (Exception en){
            System.out.println(" ");;
        }
        return false;
    }
    public boolean deleteStudentById(int id) {
        try (Connection con = db.getConnection()){
            String sql = "delete from student where id = '"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.out.println(" ");;
        }
        return false;
    }

    public boolean Reg(Login login){
        try(Connection con = db.getConnection()) {
            String sql = "INSERT INTO login(name,password) VALUES(?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login.getName());
            st.setString(2, login.getPassword());
            st.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error in Reg()");;
        }
        return false;
    }
    @Override
    public User getUser(int id) {
        try (Connection con = db.getConnection()){
            String sql = "SELECT id,name,surname,gender,address,email,phone FROM student WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"));
            }
        }catch (Exception e){
            System.out.println("Error in getUser()");;
        }
        return null;
    }

    @Override
    public boolean testReg(Login login) {
        try(Connection con = db.getConnection()) {
            String query = "select * from login where name='" + login.getName() + "' and password='" + login.getPassword() + "'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            return rs.next();
        } catch (Exception en) {
            System.out.println("Error in testReg()");;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        try (Connection con = db.getConnection()){
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
            System.out.println("Error in getAllUsers()");;
        }
        return null;
    }

    @Override
    public List<Login> getAllLogin() {
        try(Connection con = db.getConnection()) {
            String sql = "SELECT name,password FROM login";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Login> logins = new LinkedList<>();
            while (rs.next()){
                Login login = new Login(
                        rs.getString("name"),
                        rs.getString("password"));

                logins.add(login);
            }
            return logins;
        }catch (Exception e){
            System.out.println("Error in getAllLogin()");;
        }
        return null;
    }

    @Override
    public boolean creaeIdForStudent(int id) {
        try(Connection con = db.getConnection()) {
            String oop = "INSERT INTO oop(id) VALUES(?)";
            String cal2 = "INSERT INTO calculus2(id) VALUES(?)";
            String dis = "INSERT INTO dm(id) VALUES(?)";
            String pe = "INSERT INTO pe2(id) VALUES(?)";
            String fl = "INSERT INTO fl2(id) VALUES(?)";
            String itp = "INSERT INTO itp2(id) VALUES(?)";
            String ps = "INSERT INTO ps(id) VALUES(?)";
            String student = "INSERT INTO student(id) VALUES(?)";

            PreparedStatement st = con.prepareStatement(oop);
            PreparedStatement st2 = con.prepareStatement(cal2);
            PreparedStatement st3 = con.prepareStatement(dis);
            PreparedStatement st4 = con.prepareStatement(pe);
            PreparedStatement st5 = con.prepareStatement(fl);
            PreparedStatement st6 = con.prepareStatement(itp);
            PreparedStatement st7 = con.prepareStatement(ps);
            PreparedStatement st8 = con.prepareStatement(student);

            st.setInt(1, id);
            st2.setInt(1,id);
            st3.setInt(1,id);
            st4.setInt(1,id);
            st5.setInt(1,id);
            st6.setInt(1,id);
            st7.setInt(1,id);
            st8.setInt(1,id);

            st.execute();
            st2.execute();
            st3.execute();
            st4.execute();
            st5.execute();
            st6.execute();
            st7.execute();
            st8.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in createIdForStudent()");;
        }
        return false;
    }
    @Override
    public boolean loginForTeacher(Login login) {
        try (Connection con = db.getConnection()){
            String query = "select * from teacherlogin where name='" + login.getName() + "' and password='" + login.getPassword() + "'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            return rs.next();
        } catch (Exception en) {
            System.out.println("Error in loginForTeacher()");
        }
        return false;
    }

    @Override
    public boolean loginForAdmin(Login login) {
        try (Connection con = db.getConnection()){
            String query = "select * from adminlogin where name='" + login.getName() + "' and password='" + login.getPassword() + "'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            return rs.next();
        } catch (Exception en) {
            System.out.println("Error in loginForAdmin()");;
        }
        return false;
    }

}
