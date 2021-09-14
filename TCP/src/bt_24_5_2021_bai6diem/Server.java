package bt_24_5_2021_bai6diem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhieu
 */
public class Server {
    public static void main(String[] args) throws IOException{
        System.out.println("Server say hi");
        ServerSocket socket = new ServerSocket(7777);
        Socket server = socket.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
//        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
        String luaChon = dis.readUTF();
        Connection conn =JDBCConnection.getConnection();
        ThiSinh thiSinh =new ThiSinh();
        System.out.println("lua chon "+luaChon);
        List<ThiSinh> listThiSinhs = new ArrayList<ThiSinh>();
        if(luaChon.equals("2")){
            System.out.println("lua chon "+luaChon);
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select * from ThiSinh");
                while (rs.next()) {                    
                    int id =rs.getInt(1);
                    String hoTen = rs.getString(2);
                    int cmt = rs.getInt(3);
                    String diaChi = rs.getString(4);
                    int namSinh = rs.getInt(5);
                    float diem1 =rs.getFloat(6);
                    float diem2 =rs.getFloat(7);
                    float diem3 =rs.getFloat(8);
                    thiSinh = new ThiSinh(id, hoTen, cmt, diaChi, namSinh, diem1, diem2, diem3);
//                    System.out.println(thiSinh.toString());
                    listThiSinhs.add(thiSinh);
                    oos.writeObject(listThiSinhs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
           
            
        }
   
//        System.out.println(result);
//        dos.writeUTF(result);
        
            
        
    }
}
