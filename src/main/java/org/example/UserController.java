package org.example;

import interfaces.IUserRepository;

import java.util.*;

public class UserController {
    private final IUserRepository repository;

    public UserController(IUserRepository repository) {
        this.repository = repository;
    }
    public String createStudent(String name, String surname, String gender,String address,String email,String phone){
        Random ran = new Random();
        int first4 = (int) Math.abs((ran.nextLong() % 9000) + 1000);

        boolean male = (gender.toLowerCase().equals("male"));
        User user = new User( first4,name,surname,male,address,email,phone);
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
    public String deleteStudentById(int id){
        boolean created = repository.deleteStudentById(id);
        repository.creaeIdForStudent(id);
        return (created ? "Invalid ID" : "Student was deleted");
    }
    public String login(String name,String password){
        Login login = new Login(name, password);

        boolean created = repository.login(login);
        return (created ? "a":"b");
    }

    public String loginForTeacher(String name,String password){
        Login login = new Login(name, password);

        boolean created = repository.loginForTeacher(login);
        return (created ? "a":"b");
    }

    public String register(String name,String password){
        Login login = new Login(name, password);

        boolean created = repository.Reg(login);
        return (created ? "User Details Inserted Successfully":"User Not Inserted");
    }
    public String setOOPGrade(int id,String mid,String end,String fin){
        Subject subject = new Subject(mid,end,fin);

        boolean created = repository.setOOPGrade(subject,id);
        return (created ? "Subject Details Inserted Successfully":"ERRORRRRRR");
    }

    public String getAllUsers(){
        List<User> users = repository.getAllUsers();
        return users.toString();
    }

    public String getUser(int id){
        User user = repository.getUser(id);
        return (user == null ? "User was not found" : user.toString());
    }

    public String getOOPGrade(int id){
        Subject subject = repository.getOOPGrade(id);
        return (subject == null)? "Subject was not" : subject.toString();
    }


}
