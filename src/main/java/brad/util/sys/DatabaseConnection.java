package brad.util.sys;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    Connection connect() throws SQLException;
}
