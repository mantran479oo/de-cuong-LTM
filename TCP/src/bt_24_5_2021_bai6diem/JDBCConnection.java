/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_24_5_2021_bai6diem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author vuan
 */
public class JDBCConnection {  
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            java.sql.Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=TCP;user=sa;password=1;integratedSecurity=true;");
//            Statement statement=con.createStatement();
//            String url = "jdbc:sqlserver://localhost;database=TCP";
//            String username = "sa";
//            String password = "1";
//            Connection con = DriverManager.getConnection(url, username, password);
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TCP;user=sa;password=1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
		if (JDBCConnection.getConnection() != null) {
			System.out.println("Thanh cong!");
		} else {
			System.out.println("That bai!");
		}
	}
}
