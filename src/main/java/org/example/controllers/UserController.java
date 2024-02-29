package org.example.controllers;

import interfaces.IUserRepository;
import org.example.models.Login;
import org.example.models.Subject;
import org.example.models.User;

import java.util.*;

public class UserController {
    private final IUserRepository repository;

    public UserController(IUserRepository repository) {
        this.repository = repository;
    }

    public String createStudent(int id,String name, String surname, String gender, String address, String email, String phone) {
        boolean male = (gender.toLowerCase().equals("male"));

        User user = new User(name, surname, male, address, email, phone);
        boolean created = repository.createStudent(user,id);

        return (created ? "User was created!" : "User creation was failed");
    }

    public String getStudentID(int id) {
       repository.creaeIdForStudent(id);
       return null;
    }

    public String deleteStudentById(int id) {
        boolean created = repository.deleteStudentById(id);
        return (created ? "Invalid ID" : "Student was deleted");
    }

    public boolean login(String name, String password) {
        Login login = new Login(name, password);

        int id = Integer.parseInt(password);

        getOOPGrade(id);
        return repository.login(login);
    }

    public boolean loginForTeacher(String name, String password) {
        Login login = new Login(name, password);

        return repository.loginForTeacher(login);
    }
    public boolean loginForAdmin(String name,String password){
        Login login = new Login(name, password);

        return repository.loginForAdmin(login);
    }
    public String register(String name, String password) {
        Login login = new Login(name, password);

        int id = Integer.parseInt(password);
        getStudentID(id);
        boolean created = repository.Reg(login);
        return (created ? "User Details Inserted Successfully" : "User Not Inserted");
    }
    public boolean testReg(String name,String password){
        Login login = new Login(name,password);

        boolean created = repository.testReg(login);
        return created;
    }

    public String getAllUsers() {
        List<User> users = repository.getAllUsers();
        return users.toString();
    }
    public String getAllLogin(){
        List<Login> logins = repository.getAllLogin();
        return logins.toString();
    }

    public String getUser(int id) {
        User user = repository.getUser(id);
        return (user == null ? "User was not found" : user.toString());
    }

    public String getOOPGrade(int id) {
        Subject subject = repository.getOOPGrade(id);
        return (subject == null ? "Teacher did't paste grade": subject.toString());
    }

    public String setOOPGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setOOPGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }

    public String getCalculus2Grade(int id) {
        Subject subject = repository.getCalculus2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setCalculus2Grade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setCalculus2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String setIntroductionToProgramming2Grade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);
        boolean created = repository.setIntroductionToProgramming2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getIntroductionToProgramming2Grade(int id) {
        Subject subject = repository.getIntroductionToProgramming2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setPoliticalScienceGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);
        boolean created = repository.setPoliticalScienceGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getPoliticalScienceGrade(int id) {
        Subject subject = repository.getPoliticalScienceGrade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setDiscreteMathematicsGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setDiscreteMathematicsGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getDiscreteMathematicsGrade(int id) {
        Subject subject = repository.getDiscreteMathematicsGrade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }

}
