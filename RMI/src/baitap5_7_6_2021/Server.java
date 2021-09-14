/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap5_7_6_2021;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuan
 */
public class Server extends UnicastRemoteObject implements RMIInterface {

    public Server() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(3232);
        registry.rebind("server", this);
    }

    public static void main(String[] args) throws RemoteException {
        Server s = new Server();
    }

    @Override
    public String danhSachHocSinh() throws RemoteException {
        String kq="";
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
                kq+=hs.toString()+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public String danhSachHocSinhHocBong() throws RemoteException {
        String kq="";
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
                kq+=hs.toString()+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public String nhapDiem(float diemTongKet ,int id) throws RemoteException {
        System.out.println("server diemTK"+diemTongKet);
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
        return "update thanh cong";
    }
}
