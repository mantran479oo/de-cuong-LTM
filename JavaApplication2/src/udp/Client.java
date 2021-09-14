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

/**
 *
 * @author vuan
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket myclient = new DatagramSocket();
        String a = "hello server";
        byte[] send_data = a.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket send_pack  = new DatagramPacket(send_data, send_data.length, ip, 7);
        myclient.send(send_pack);
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myclient.receive(pack_receive);
        System.out.println("Client nhan:"+new String(pack_receive.getData()));
    }
}   
