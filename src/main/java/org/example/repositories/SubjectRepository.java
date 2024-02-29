package org.example.repositories;

import interfaces.IDB;
import interfaces.ISubjectRepository;
import org.example.models.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubjectRepository implements ISubjectRepository {
    private final IDB db;
    public SubjectRepository(IDB db) {
        this.db = db;
    }
    public boolean setOOPGrade(Subject subject, int id) {
        try(Connection con = db.getConnection()) {
            String sql = "UPDATE oop SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, subject.getMidterm());
            st.setInt(2, subject.getEndterm());
            st.setInt(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Erorr in setOOPGrate()");;
        }
        return false;
    }
    public Subject getOOPGrade(int id) {
        try(Connection con = db.getConnection()) {
            String sql = "SELECT midterm,endterm,final FROM oop WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return new Subject(
                        rs.getInt("midterm"),
                        rs.getInt("endterm"),
                        rs.getInt("final"),
                        calTotal(rs.getInt("midterm"), rs.getInt("endterm"), rs.getInt("final")));
            }
        } catch (Exception e) {
            System.out.println("Erorr in getOOPGrade()");
        }
        return null;
    }
    @Override
    public boolean setCalculus2Grade(Subject subject,int id) {
        try (Connection con = db.getConnection()){
            String sql = "UPDATE calculus2 SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, subject.getMidterm());
            st.setInt(2, subject.getEndterm());
            st.setInt(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in setCalculus2Grade()");
        }
        return false;
    }
    @Override
    public Subject getCalculus2Grade(int id) {
        try(Connection con = db.getConnection()) {
            String sql = "SELECT midterm,endterm,final FROM calculus2 WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return new Subject(
                        rs.getInt("midterm"),
                        rs.getInt("endterm"),
                        rs.getInt("final"),
                        calTotal(rs.getInt("midterm"), rs.getInt("endterm"), rs.getInt("final")));
            }
        } catch (Exception e) {
            System.out.println("Error in getCalculus2Grade()");
        }
        return null;
    }
    public boolean setIntroductionToProgramming2Grade(Subject subject,int id) {
        try(Connection con = db.getConnection()) {
            String sql = "UPDATE itp2 SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, subject.getMidterm());
            st.setInt(2, subject.getEndterm());
            st.setInt(3, subject.getFianll());
            st.setInt(4,id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in setIntroductionToProgramming2Grade()");;
        }
        return false;
    }
    public Subject getIntroductionToProgramming2Grade(int id) {
        try (Connection con = db.getConnection()){
            String sql = "SELECT midterm,endterm,final FROM itp2 WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return new Subject(
                        rs.getInt("midterm"),
                        rs.getInt("endterm"),
                        rs.getInt("final"),
                        calTotal( rs.getInt("midterm"), rs.getInt("endterm"), rs.getInt("final")));
            }
        } catch (Exception e) {
            System.out.println("Error in getIntroductionToProgramming2Grade()");
        }
        return null;
    }
    public boolean setPoliticalScienceGrade(Subject subject,int id) {
        try(Connection con = db.getConnection()) {
            String sql = "UPDATE ps SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, subject.getMidterm());
            st.setInt(2, subject.getEndterm());
            st.setInt(3, subject.getFianll());
            st.setInt(4,id);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in setPoliticalScienceGrade()");;
        }
        return false;
    }
    public Subject getPoliticalScienceGrade(int id) {
        try (Connection con = db.getConnection()){
            String sql = "SELECT midterm,endterm,final FROM ps WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return new Subject(
                        rs.getInt("midterm"),
                        rs.getInt("endterm"),
                        rs.getInt("final"),
                        calTotal(rs.getInt("midterm"), rs.getInt("endterm"), rs.getInt("final")));
            }
        } catch (Exception e) {
            System.out.println("Error in getPoliticalScienceGrade()");
        }
        return null;
    }
    public boolean setDiscreteMathematicsGrade(Subject subject,int id) {
        try (Connection con = db.getConnection()){
            String sql = "UPDATE dm SET midterm = ?, endterm = ?, final = ?   WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, subject.getMidterm());
            st.setInt(2, subject.getEndterm());
            st.setInt(3, subject.getFianll());
            st.setInt(4,id);

            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in setDiscreteMathematicsGrade()");;
        }
        return false;
    }
    public Subject getDiscreteMathematicsGrade(int id) {
        try (Connection con = db.getConnection()){
            String sql = "SELECT midterm,endterm,final FROM dm WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return new Subject(
                        rs.getInt("midterm"),
                        rs.getInt("endterm"),
                        rs.getInt("final"),
                        calTotal(rs.getInt("midterm"), rs.getInt("endterm"), rs.getInt("final")));
            }
        } catch (Exception e) {
            System.out.println("Error in getDiscreteMathematicsGrade()");
        }
        return null;
    }
    public int calTotal(int mid, int end, int fin) {
        double total = (double) ((mid + end) / 2) * 0.6 + fin * 0.4;
        return  (int) (total);
    }

}
