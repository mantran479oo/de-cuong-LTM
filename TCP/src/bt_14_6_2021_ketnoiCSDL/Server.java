/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_14_6_2021_ketnoiCSDL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vuan
 */
public class Server {

    public static void main(String[] args) throws RemoteException, IOException {
        ServerSocket socket = new ServerSocket(7777);
        Socket server = socket.accept();
        System.out.println("Server say hi");
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        String luachon = dis.readUTF();
        String kq = "";
        System.out.println(luachon);
        while (true) {            
            if (luachon.equals("1")) {
                kq = danhSachHocSinh();
                dos.writeUTF(kq);
            } else if (luachon.equals("2")) {
                kq = danhSachHocSinhHocBong();
                dos.writeUTF(kq);
            } else {
                System.out.println("th khac");
                String[] receive = luachon.split(" ");
                System.out.println(receive[0]+receive[1]+receive[2]);
                System.out.println("sua diem");
                kq = nhapDiem(Float.parseFloat(receive[2]), Integer.parseInt(receive[1]));
                dos.writeUTF(kq);
            }
            
        }
        
    }

    public static String danhSachHocSinh() throws RemoteException {
        String kq = "";
        Connection conn = JDBCConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from hocsinh");
            while (rs.next()) {
                int maSV = rs.getInt(1);
                String ten = rs.getString(2);
                String diaChi = rs.getString(3);
                String gioiTinh = rs.getString(4);
                float diemTongKet = rs.getFloat(5);
                HocSinh hs = new HocSinh(maSV, ten, diaChi, gioiTinh, diemTongKet);
                kq += hs.toString() + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static String danhSachHocSinhHocBong() throws RemoteException {
        String kq = "";
        Connection conn = JDBCConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from hocsinh where hocsinh.diemTongKet > 8");
            while (rs.next()) {
                int maSV = rs.getInt(1);
                String ten = rs.getString(2);
                String diaChi = rs.getString(3);
                String gioiTinh = rs.getString(4);
                float diemTongKet = rs.getFloat(5);
                HocSinh hs = new HocSinh(maSV, ten, diaChi, gioiTinh, diemTongKet);
                kq += hs.toString() + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static String nhapDiem(float diemTongKet, int id) throws RemoteException {
        System.out.println("server diemTK" + diemTongKet);
        System.out.println("id " + id);
        try {
            String sql = "UPDATE hocsinh SET hocsinh.diemTongKet = ? WHERE maSV = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setFloat(1, diemTongKet);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "upd ate thanh cong";
    }
}
