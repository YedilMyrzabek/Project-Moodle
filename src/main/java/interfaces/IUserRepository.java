package interfaces;
import org.example.models.Login;
import org.example.models.Subject;
import org.example.models.User;

import java.util.List;

public interface IUserRepository {
    boolean createStudent(User user,int id);
    boolean creaeIdForStudent(int id);
    User getUser(int id);

    List<User> getAllUsers();
    List<Login> getAllLogin();
}
