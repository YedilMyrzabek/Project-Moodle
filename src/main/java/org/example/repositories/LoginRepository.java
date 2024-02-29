package org.example.repositories;

import interfaces.IDB;
import interfaces.ILoginRepository;
import org.example.models.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginRepository implements ILoginRepository {
    private final IDB db;
    public LoginRepository(IDB db) {
        this.db = db;
    }

    @Override
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

    @Override
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

    @Override
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
}
