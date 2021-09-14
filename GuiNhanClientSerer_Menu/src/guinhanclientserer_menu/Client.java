/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guinhanclientserer_menu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client {public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket myclient = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap 2 so a va b");
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println("================MENU====================");
        System.out.println("1.Tinh tong hai so");
        System.out.println("2.Tinh hieu hai so");
        int luaChon = sc.nextInt();
        //client gui
        if(luaChon == 1){
            String pack = "1"+" "+a+" "+b;
            byte[] send_data =pack.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket send_pack  = new DatagramPacket(send_data, send_data.length, ip, 7);
            myclient.send(send_pack);   
        }
        if(luaChon == 2){
            String pack = "2"+" "+a+" "+b;
            byte[] send_data =pack.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket send_pack  = new DatagramPacket(send_data, send_data.length, ip, 7);
            myclient.send(send_pack);
        }
        
        //client nhan
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myclient.receive(pack_receive);
        System.out.println("Ket qua la:"+new String(pack_receive.getData()));
    }
    
}
