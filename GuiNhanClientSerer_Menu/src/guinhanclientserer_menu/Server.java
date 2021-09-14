/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guinhanclientserer_menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Logger;

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
        String s = new String(pack_receive.getData(),0 ,pack_receive.getLength());
        System.out.println(s);
        String [] data_receive = s.split(" ");
        int kq = 0;
        if(Integer.parseInt(data_receive[0]) == 1){
            kq = Integer.parseInt(data_receive[1])+Integer.parseInt(data_receive[2]);
        }
        if(Integer.parseInt(data_receive[0]) == 2){
            kq = Integer.parseInt(data_receive[1])-Integer.parseInt(data_receive[2]);
        }
        byte[] send_data = String.valueOf(kq).getBytes();
        DatagramPacket send_packet = new DatagramPacket(send_data, send_data.length, pack_receive.getAddress(), pack_receive.getPort());
        myserver.send(send_packet);

        
    }
}
