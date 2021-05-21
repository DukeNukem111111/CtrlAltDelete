import java.sql.Connection;
import  java.sql.*;

public class database {
    public static Connection reservations(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jbdc.driver");
            con = DriverManager.getConnection("");
        }
    }
}
