import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Database db = new Database();
            System.out.println("Database is connected: " + db.isConnected());

         HalAwal test = new HalAwal();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}