import java.sql.Connection;
import java.sql.DriverManager;

public class db {

    public static Connection mycon(){

        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javapos","duke","12345");
            return con;
        } catch (Exception f){
            System.out.println(f);
            return null;
        }
    }
}
