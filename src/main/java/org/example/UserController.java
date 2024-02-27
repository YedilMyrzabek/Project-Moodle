package org.example;

import interfaces.IUserRepository;

import java.util.*;

public class UserController {
    private final IUserRepository repository;

    public UserController(IUserRepository repository) {
        this.repository = repository;
    }

    public String createStudent(String name, String surname, String gender, String address, String email, String phone) {
        boolean male = (gender.toLowerCase().equals("male"));
        Random ran = new Random();
        int first4 = (int) Math.abs((ran.nextLong() % 9000) + 1000);

        User user = new User(first4, name, surname, male, address, email, phone);
        boolean created = repository.createStudent(user);

        getStudentID(first4);
        getOOPGrade(first4);
        return (created ? "User was created!" : "User creation was failed");
    }

    public String getStudentID(int id) {
        repository.getOOPGrade(id);
        repository.creaeIdForStudent(id);
        return null;
    }

    public String deleteStudentById(int id) {
        boolean created = repository.deleteStudentById(id);
        return (created ? "Student was deleted" : "Invalid ID");
    }

    public String login(String name, String password) {
        Login login = new Login(name, password);

        boolean created = repository.login(login);
        return (created ? "a":"b");
    }

    public String loginForTeacher(String name, String password) {
        Login login = new Login(name, password);

        boolean created = repository.loginForTeacher(login);
        return (created ? "a" : "b");
    }

    public String register(String name, String password) {
        Login login = new Login(name, password);

        boolean created = repository.Reg(login);
        return (created ? "User Details Inserted Successfully" : "User Not Inserted");
    }

    public String setOOPGrade(int id, String mid, String end, String fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setOOPGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }

    public String getAllUsers() {
        List<User> users = repository.getAllUsers();
        return users.toString();
    }

    public String getUser(int id) {
        User user = repository.getUser(id);
        return (user == null ? "User was not found" : user.toString());
    }

    public String getOOPGrade(int id) {
        Subject subject = repository.getOOPGrade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String getCalculus2Grade(int id) {
        Subject subject = repository.getCalculus2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setCalculus2Grade(int id, String mid, String end, String fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setCalculus2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String setForeignLanguage2Grade(int id, String mid, String end, String fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setForeignLanguage2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getForeignLanguage2Grade(int id) {
        Subject subject = repository.getForeignLanguage2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setPhysicalEducation2Grade(int id, String mid, String end, String fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setPhysicalEducation2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getPhysicalEducation2Grade(int id) {
        Subject subject = repository.getPhysicalEducation2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
}
