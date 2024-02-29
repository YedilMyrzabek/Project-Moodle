package org.example.resources;

import interfaces.IDB;
import interfaces.IUserRepository;
import interfaces.DB.PostgresDB;
import org.example.controllers.UserController;
import org.example.repositories.UserRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();

    }
}
