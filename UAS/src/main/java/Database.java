import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection db;

    public Database() throws ClassNotFoundException, SQLException {
        //Load JDBC driver for MySQL database
        //Class.forName("com.mysql.jdbc.Driver");

        //Establish connection to MySQL Server
        db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");
    }

    public boolean isConnected(){
        return (db != null);
    }


}
