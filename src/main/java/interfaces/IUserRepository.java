package interfaces;
import org.example.models.Login;
import org.example.models.Subject;
import org.example.models.User;

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

    List<User> getAllUsers();
    List<Login> getAllLogin();
}
