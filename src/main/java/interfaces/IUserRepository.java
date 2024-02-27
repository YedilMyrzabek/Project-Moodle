package interfaces;
import org.example.Login;
import org.example.Subject;
import org.example.User;

import java.util.List;

public interface IUserRepository {
    boolean createStudent(User user);

    boolean creaeIdForStudent(int id);

    boolean login(Login login);

    boolean loginForTeacher(Login login);

    boolean deleteStudentById(int id);

    boolean Reg(Login login);

    User getUser(int id);

    Subject getOOPGrade(int id);

    boolean setOOPGrade(Subject subject, int id);

    Subject getCalculus2Grade(int id);

    boolean setCalculus2Grade(Subject subject, int id);

    Subject getForeignLanguage2Grade(int id);

    boolean setForeignLanguage2Grade(Subject subject, int id);

    List<User> getAllUsers();

}
