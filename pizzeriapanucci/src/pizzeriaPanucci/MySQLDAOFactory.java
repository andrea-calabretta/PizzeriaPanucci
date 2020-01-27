package pizzeriaPanucci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory{

    public static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/pizzeriapanucci?useSSL=false&serverTimezone=UTC";
    public static final String USER = "pizzeriapanucci";
    public static final String PASS = "pizzeriapanucci";

    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }


    @Override
    public ClienteDAO getClienteDAO() {
        return new MySQLClienteDAOImpl();
    }
}
