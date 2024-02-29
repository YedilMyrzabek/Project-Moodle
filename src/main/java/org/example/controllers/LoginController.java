package org.example.controllers;

import interfaces.ILoginRepository;
import org.example.models.Login;

public class LoginController {
    private final ILoginRepository repository;
    public String register(String name, String password) {
        Login login = new Login(name, password);

        boolean created = repository.Reg(login);
        return (created ? "User Details Inserted Successfully" : "User Not Inserted");
    }

    public String deleteStudentById(int id) {
        boolean created = repository.deleteStudentById(id);
        return (created ? "Invalid ID" : "Student was deleted");
    }

    public boolean login(String name, String password) {
        Login login = new Login(name, password);

        return repository.login(login);
    }

    public LoginController(ILoginRepository repository) {
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
