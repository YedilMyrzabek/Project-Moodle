package interfaces;
import org.example.Login;
import org.example.User;

import java.util.List;

public interface IUserRepository {
    boolean createStudent(User user);
    boolean login(Login login);
    boolean deleteStudentById(int id);
    boolean Reg(Login login);
    User getUser(int id);
    List<User> getAllUsers();
}
