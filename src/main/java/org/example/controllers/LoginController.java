package org.example.controllers;

import interfaces.IUserRepository;
import org.example.models.Login;

public class LoginController {
    private final IUserRepository repository;
    public String register(String name, String password) {
        Login login = new Login(name, password);

        boolean created = repository.Reg(login);
        return (created ? "User Details Inserted Successfully" : "User Not Inserted");
    }
    public boolean login(String name, String password) {
        Login login = new Login(name, password);

        return repository.login(login);
    }

    public LoginController(IUserRepository repository) {
        this.repository = repository;
    }

    public boolean loginForTeacher(String name, String password) {
        Login login = new Login(name, password);

        return repository.loginForTeacher(login);
    }
    public boolean loginForAdmin(String name,String password){
        Login login = new Login(name, password);

        return repository.loginForAdmin(login);
    }

    public boolean testReg(String name,String password){
        Login login = new Login(name,password);

        boolean created = repository.testReg(login);
        return created;
    }
}
