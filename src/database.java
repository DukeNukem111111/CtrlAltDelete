import java.sql.Connection;
import  java.sql.*;

public class database {
    public static Connection reservations(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jbdc.driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javapos","duke","12345");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
