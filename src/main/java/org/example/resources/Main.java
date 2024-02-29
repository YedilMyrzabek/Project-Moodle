package org.example.resources;

import interfaces.IDB;
import interfaces.ILoginRepository;
import interfaces.IUserRepository;
import interfaces.DB.PostgresDB;
import interfaces.ISubjectRepository;
import org.example.controllers.LoginController;
import org.example.controllers.SubjectController;
import org.example.controllers.UserController;
import org.example.models.Subject;
import org.example.repositories.LoginRepository;
import org.example.repositories.SubjectRepository;
import org.example.repositories.UserRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        ISubjectRepository subRepo = new SubjectRepository(db);
        ILoginRepository logRepo = new LoginRepository(db);
        UserController controller = new UserController(repo);
        LoginController loginController = new LoginController(logRepo);
        SubjectController subjectController = new SubjectController(subRepo);
        MyApplication app = new MyApplication(controller,loginController,subjectController);
        app.start();
    }
}
