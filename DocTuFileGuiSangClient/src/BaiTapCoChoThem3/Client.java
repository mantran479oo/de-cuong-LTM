/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaiTapCoChoThem3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author nhu
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        Scanner sc= new Scanner(System.in);
        String kq="";
        while (true) {
            System.out.println("=================Menu====================");
            System.out.println("1.Hien thi toan bo danh sach hoc sinh");
            System.out.println("2 Hien thi danh sach hoc sinh co hoc bong");
            System.out.println("3.Nhap diem cho hoc sinh");    
            System.out.println("4.Thoat");
            int luaChon= Integer.parseInt(sc.nextLine());
            if (luaChon == 1) {
                kq = luaChon + " hien thi toan bo";
                send_receive(kq);
            }
            if (luaChon == 2) {
                kq = luaChon + " hoc sinh co hoc bong";
                send_receive(kq);
            }
            if (luaChon == 3) {
                System.out.println("Chon hoc sinh");
                int stt = Integer.parseInt(sc.nextLine());
                System.out.println("nhap diem muon sua cho hoc sinh");
                float diem = Float.parseFloat(sc.nextLine() );
                kq = luaChon + " nhapdiemchohocsinh " +stt+" "+diem;
                send_receive(kq);
            }if(luaChon == 4){
                break;
            }
        }

        
        
        
    
    }
    
    public static void send_receive(String kq) throws UnknownHostException, IOException{
        DatagramSocket client = new DatagramSocket();
        byte[] send_data = kq.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket send_pack = new DatagramPacket(send_data, send_data.length, ip, 3232);
        client.send(send_pack);

        byte[] receive_data = new byte[1024];
        DatagramPacket packet_receive = new DatagramPacket(receive_data, receive_data.length);
        client.receive(packet_receive);
        String a = new String(packet_receive.getData(), 0, packet_receive.getLength());
        System.out.println("\n"+a);
    }
    
}
