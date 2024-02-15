package interfaces;

import java.sql.Connection;
import java.sql.SQLException;


public interface IDB {
    //Connection interface
    Connection getConnection() throws SQLException,ClassNotFoundException;
}
