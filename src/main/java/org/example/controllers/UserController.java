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

}
