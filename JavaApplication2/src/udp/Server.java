/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author vuan
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket myserver = new DatagramSocket(7);
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myserver.receive(pack_receive);
        String s = new String(pack_receive.getData());
        System.out.println("Server nhan :"+s);
        String a = "Hello Client";
        byte[] send_data = a.getBytes();
        DatagramPacket send_packet = new DatagramPacket(send_data, send_data.length, pack_receive.getAddress(), pack_receive.getPort());
        myserver.send(send_packet);
    }
}
