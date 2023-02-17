package databaseconsoles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {
    public static void main(String[] args) {
       try {
            String host = "jdbc:derby://localhost:1527/Employees";
            String uName = "nasser";
            String uPass = "nasser";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();
            String SQL = "select * from NASSER.WORKERS";
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("Fist_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Job_title");
                String p = id_col + "" + first_name + "" + last_name + ""  + job;
                System.out.println(p);
            }
       }
       catch( SQLException err) {
           System.out.println(err.getMessage());
       }
    }
    
}
