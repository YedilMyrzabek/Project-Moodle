package org.example.resources;

import interfaces.IDB;
import interfaces.IUserRepository;
import interfaces.DB.PostgresDB;
import interfaces.ISubjectRepository;
import org.example.controllers.LoginController;
import org.example.controllers.SubjectController;
import org.example.controllers.UserController;
import org.example.repositories.SubjectRepository;
import org.example.repositories.UserRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        ISubjectRepository subRepo = new SubjectRepository(db);
        UserController controller = new UserController(repo);
        LoginController loginController = new LoginController(repo);
        SubjectController subjectController = new SubjectController(subRepo);
        MyApplication app = new MyApplication(controller,loginController,subjectController);
        app.start();

    }
}
