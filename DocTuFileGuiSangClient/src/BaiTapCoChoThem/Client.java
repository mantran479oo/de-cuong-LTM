/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapCoChoThem;

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
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket myclient = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("================MENU====================");
        System.out.println("1.Hien thi thong tin nhan vien");
        System.out.println("2.Tim kiem nhan vien");
        int luaChon = Integer.parseInt(sc.nextLine());
        InetAddress ip= InetAddress.getByName("localhost");
        String pack="";
        switch(luaChon){
            case 1:{
                pack= luaChon+" "+"all";
                break;
            }
            case 2:{
                System.out.println("Nhap ten:");
                String name= sc.nextLine();
//                pack= luaChon+" "+ name;
                pack=  name;
                break;
            }
        }
        byte[] send_data= pack.getBytes();
        DatagramPacket dp= new DatagramPacket(send_data, send_data.length, ip, 7);
        myclient.send(dp);
        //client nhan
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myclient.receive(pack_receive);
        System.out.println("Ket qua la:"+new String(pack_receive.getData()));
    }
    
}
