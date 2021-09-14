/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

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
        String s = "yc";
        byte[] send_data =s.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket send_pack  = new DatagramPacket(send_data, send_data.length, ip, 7);
        myclient.send(send_pack);
        
        //client gui
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myclient.receive(pack_receive);
        System.out.println("Client nhan kq tu server:"+new String(pack_receive.getData()));
    }
    
}
