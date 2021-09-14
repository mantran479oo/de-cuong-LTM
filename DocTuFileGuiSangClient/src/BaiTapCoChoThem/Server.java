/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapCoChoThem;

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
        String s = new String(pack_receive.getData(), 0, pack_receive.getLength());
        System.out.println(s);
        String[] data_receive = s.split(" ");
        BufferedReader reader = new BufferedReader(new FileReader("D:\\nhanvien.txt"));
        String line = reader.readLine();
        String kq = "";
        if (data_receive[0].equals("1")) {
            try {
                while (line != null) {
                    String[] info = line.split(" ");
                    System.out.println(info[0] + " " + info[1]);
                    kq += info[0] + " " + info[1] + " " + info[2] + "\n";
                    line = reader.readLine();
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {

            String name = data_receive[1];
            System.out.println("name :" + name);
            try {
                System.out.println("search " + line);
                while (line != null) {
                    String[] info = line.split(" ");
//                System.out.println("doc tu file:"+info[0]);
//                if(name.equals(info[0])){
//                    kq=info[0]+" "+info[1]+" "+info[2];
//                }else {
//                    kq="Khong tim thay nhan vien nao";
//                }

                    for (int i = 0; i < info.length; i++) {
                        if (s.equals(info[i])) {
                            kq += line;
                            break;

                        }
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
//        if (data_receive[0].equals("2")) {
//            String name = data_receive[1];
//            System.out.println("name :" + name);
//            try {
//                System.out.println("search " + line);
//                while (line != null) {
//                    String[] info = line.split(" ");
////                System.out.println("doc tu file:"+info[0]);
////                if(name.equals(info[0])){
////                    kq=info[0]+" "+info[1]+" "+info[2];
////                }else {
////                    kq="Khong tim thay nhan vien nao";
////                }
//
//                    for (int i = 0; i < info.length; i++) {
//                        if (s.equals(info[i])) {
//                            kq += line;
//                            break;
//
//                        }
//                    }
//                    line = reader.readLine();
//                }
//                reader.close();
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            }
//        }
        System.out.println("gia tri cua kq la:" + kq);
        byte[] send_data = kq.getBytes();
        DatagramPacket send_packet = new DatagramPacket(send_data, send_data.length, pack_receive.getAddress(), pack_receive.getPort());
        myserver.send(send_packet);

    }
}
