package employeemanagementsystem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    Connection conn;
    Statement stmt;

    public JDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");
            Statement stmt = conn.createStatement();
            System.out.println("Connected sucessfully.....");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

//    public static void main(String args[]) {
//        new JDBCConnection();
//    }
}
