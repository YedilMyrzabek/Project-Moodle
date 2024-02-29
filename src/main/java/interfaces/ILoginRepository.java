package interfaces;

import org.example.models.Login;

public interface ILoginRepository {
    boolean login(Login login);
    boolean loginForTeacher(Login login);
    boolean loginForAdmin(Login login);
    boolean deleteStudentById(int id);
    boolean Reg(Login login);
    boolean testReg(Login login);
}
