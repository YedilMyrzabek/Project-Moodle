package org.example;


import interfaces.IDB;
import interfaces.IUserRepository;

import java.sql.*;
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
            String sql = "INSERT INTO student(id,name,surname,gender,address,email,phone) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,user.getStudentID());
            st.setString(2, user.getName());
            st.setString(3, user.getSurname());
            st.setBoolean(4,user.isGender());
            st.setString(5, user.getAddress());
            st.setString(6, user.getEmail());
            st.setString(7, user.getPhone());

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
    public boolean creaeIdForStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO oop(id) VALUES(?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean loginForTeacher(Login login) {
        Connection con = null;
        try {
            con = db.getConnection();
            String query = "select * from teacherlogin where name='" + login.getName() + "' and password='" + login.getPassword() + "'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception en) {
            en.printStackTrace();
        }
        return false;
    }

    public boolean setOOPGrade(Subject subject,int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE oop SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getMidterm());
            st.setString(2, subject.getEndterm());
            st.setString(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    public Subject getOOPGrade(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT midterm,endterm,final FROM oop WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int mid = Integer.parseInt(rs.getString("midterm"));
                int end = Integer.parseInt(rs.getString("endterm"));
                int fin = Integer.parseInt(rs.getString("final"));

                Subject subject = new Subject(
                        rs.getString("midterm"),
                        rs.getString("endterm"),
                        rs.getString("final"),
                        calTotal(mid, end, fin));
                return subject;
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                System.out.println("");;
            }
        }

        return null;

    }
    @Override
    public boolean setCalculus2Grade(Subject subject,int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE calculus2 SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getMidterm());
            st.setString(2, subject.getEndterm());
            st.setString(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public Subject getCalculus2Grade(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT midterm,endterm,final FROM calculus2 WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int mid = Integer.parseInt(rs.getString("midterm"));
                int end = Integer.parseInt(rs.getString("endterm"));
                int fin = Integer.parseInt(rs.getString("final"));

                Subject subject = new Subject(
                        rs.getString("midterm"),
                        rs.getString("endterm"),
                        rs.getString("final"),
                        calTotal(mid, end, fin));
                return subject;
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                System.out.println("");;
            }
        }

        return null;
    }
    @Override
    public boolean setForeignLanguage2Grade(Subject subject,int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE ForeignLanguage2 SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getMidterm());
            st.setString(2, subject.getEndterm());
            st.setString(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    public Subject getForeignLanguage2Grade(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT midterm,endterm,final FROM ForeignLanguage2 WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int mid = Integer.parseInt(rs.getString("midterm"));
                int end = Integer.parseInt(rs.getString("endterm"));
                int fin = Integer.parseInt(rs.getString("final"));

                Subject subject = new Subject(
                        rs.getString("midterm"),
                        rs.getString("endterm"),
                        rs.getString("final"),
                        calTotal(mid, end, fin));
                return subject;
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                System.out.println("");;
            }
        }

        return null;
    }
    public boolean setPhysicalEducation2Grade(Subject subject,int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE PhysicalEducation2 SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getMidterm());
            st.setString(2, subject.getEndterm());
            st.setString(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    public Subject getPhysicalEducation2Grade(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT midterm,endterm,final FROM PhysicalEducation2 WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int mid = Integer.parseInt(rs.getString("midterm"));
                int end = Integer.parseInt(rs.getString("endterm"));
                int fin = Integer.parseInt(rs.getString("final"));

                Subject subject = new Subject(
                        rs.getString("midterm"),
                        rs.getString("endterm"),
                        rs.getString("final"),
                        calTotal(mid, end, fin));
                return subject;
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                System.out.println("");;
            }
        }

        return null;
    }
    public boolean setIntroductionToProgramming2Grade(Subject subject,int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE IntroductionToProgramming2 SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getMidterm());
            st.setString(2, subject.getEndterm());
            st.setString(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    public Subject getIntroductionToProgramming2Grade(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT midterm,endterm,final FROM IntroductionToProgramming2 WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int mid = Integer.parseInt(rs.getString("midterm"));
                int end = Integer.parseInt(rs.getString("endterm"));
                int fin = Integer.parseInt(rs.getString("final"));

                Subject subject = new Subject(
                        rs.getString("midterm"),
                        rs.getString("endterm"),
                        rs.getString("final"),
                        calTotal(mid, end, fin));
                return subject;
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                System.out.println("");;
            }
        }

        return null;
    }
    public boolean setPoliticalScienceGrade(Subject subject,int id) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE PoliticalScience SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, subject.getMidterm());
            st.setString(2, subject.getEndterm());
            st.setString(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception es) {
                es.printStackTrace();
            }
        }
        return false;
    }
    public Subject getPoliticalScienceGrade(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT midterm,endterm,final FROM PoliticalScience WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int mid = Integer.parseInt(rs.getString("midterm"));
                int end = Integer.parseInt(rs.getString("endterm"));
                int fin = Integer.parseInt(rs.getString("final"));

                Subject subject = new Subject(
                        rs.getString("midterm"),
                        rs.getString("endterm"),
                        rs.getString("final"),
                        calTotal(mid, end, fin));
                return subject;
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {

            try {
                con.close();
            } catch (Exception es) {
                System.out.println("");;
            }
        }

        return null;
    }
    public String calTotal(int mid, int end, int fin) {
        double total = (double) ((mid + end) / 2) * 0.6 + fin * 0.4;
        String s = Double.toString(total);
        return s;
    }
}
