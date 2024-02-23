package org.example;

import interfaces.IUserRepository;

import java.util.*;

public class UserController {
    private final IUserRepository repository;

    public UserController(IUserRepository repository) {
        this.repository = repository;
    }
    public String createStudent(String name, String surname, String gender,String address,String email,String phone){
        boolean male = (gender.toLowerCase().equals("male"));
        User user = new User(name,surname,male,address,email,phone);

        boolean created = repository.createStudent(user);

        return (created ? "User was created!" : "User creation was failed");
    }
    public String deleteStudentById(int id){
        boolean created = repository.deleteStudentById(id);
        return (created ? "Student was deleted" : "Invalid ID");
    }
    public String login(String name,String password){
        Login login = new Login(name, password);

        boolean created = repository.login(login);
        return (created ? "a":"b");
    }

    public String register(String name,String password){
        Login login = new Login(name, password);

        boolean created = repository.Reg(login);
        return (created ? "User Details Inserted Successfully":"User Not Inserted");
    }

    public String getAllUsers(){
        List<User> users = repository.getAllUsers();
        return users.toString();
    }
    public String getUser(int id){
        User user = repository.getUser(id);
        return (user == null ? "User was not found" : user.toString());
    }

}
