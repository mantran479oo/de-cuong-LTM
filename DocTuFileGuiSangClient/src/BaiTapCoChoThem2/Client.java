/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp_menu_file;

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
        DatagramSocket client= new DatagramSocket();
        Scanner sc= new Scanner(System.in);
        String kq="";
        System.out.println("1. tim kiem \n 2. hien thi toan bo thong tin");
        int chon= Integer.parseInt(sc.nextLine());
        switch(chon){
            case 1:{
                System.out.println("Nhap ten can tim kiem:");
                kq=chon+" "+ sc.nextLine();
                break;
            }
            case 2: {
                kq=chon+ " "+ "all infor";
            }
            default:
                System.out.println("chi dc chon 1 hoac 2");
        }
        byte[] send_data= kq.getBytes();
        InetAddress ip= InetAddress.getByName("localhost");
        DatagramPacket send_pack= new DatagramPacket(send_data, send_data.length,ip, 3232);
        client.send(send_pack);
        
         byte[] receive_data= new byte[1024];
            DatagramPacket packet_receive= new DatagramPacket(receive_data, receive_data.length);
            client.receive(packet_receive);
            String a= new String(packet_receive.getData(), 0,packet_receive.getLength());
            System.out.println( a);
    
    }

}
