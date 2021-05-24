import java.sql.Connection;
import java.sql.DriverManager;


//Establishing connection to javapos database, table specification is done by classes to make things much easier, loose coupling.
public class db {

    public static Connection mycon(){

        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javapos","root","");
            return con;
        } catch (Exception f){
            System.out.println(f);
            return null;
        }
    }
}