/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnect {
//    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYTIENDIEN;";
//    private static final String USERNAME = "sa";
//    private static final String PASSWORD = "123456";
    private Connection connection;
    public Connection connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName=QuanLiTienNuoc;user=sa;password=sa");
            if (connection != null)
                System.out.println("Kết nối thành công");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return connection;
    }
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
