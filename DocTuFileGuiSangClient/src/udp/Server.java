/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

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
        String s = new String(pack_receive.getData());
        System.out.println(s);
//        String url = "C:\\nhanvien.txt";
//        
//        File file = new File(url);
        BufferedReader reader = new BufferedReader(new FileReader("E://nhanhvien.txt"));
        String kq="";
        try {
            String line = reader.readLine();
            while (line != null) {
                String [] info = line.split("\\$");
                System.out.println(info[0]+" "+info[1]);
                kq += info[0]+" "+info[1]+"\n";
                line = reader.readLine();
            }
            byte[] send_data = kq.getBytes();
            DatagramPacket send_packet = new DatagramPacket(send_data, send_data.length, pack_receive.getAddress(), pack_receive.getPort());
            myserver.send(send_packet);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
}
