package interfaces;
import org.example.Login;
import org.example.Subject;
import org.example.User;

import java.util.List;

public interface IUserRepository {
    boolean createStudent(User user,int id);

    boolean creaeIdForStudent(int id);

    boolean login(Login login);

    boolean loginForTeacher(Login login);
    boolean loginForAdmin(Login login);

    boolean deleteStudentById(int id);

    boolean Reg(Login login);

    User getUser(int id);
    boolean testReg(Login login);

    Subject getOOPGrade(int id);

    boolean setOOPGrade(Subject subject, int id);
    Subject getCalculus2Grade(int id);
    boolean setCalculus2Grade(Subject subject, int id);
    Subject getIntroductionToProgramming2Grade(int id);

    boolean setIntroductionToProgramming2Grade(Subject subject, int id);

    Subject getPoliticalScienceGrade(int id);

    boolean setPoliticalScienceGrade(Subject subject, int id);

    Subject getDiscreteMathematicsGrade(int id);

    boolean setDiscreteMathematicsGrade(Subject subject, int id);


    List<User> getAllUsers();
    List<Login> getAllLogin();
}
