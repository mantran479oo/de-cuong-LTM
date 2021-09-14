/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaiTapCoChoThem3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author nhu
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
         DatagramSocket server = new DatagramSocket(3232);
        while (true) {
            BufferedReader br = new BufferedReader(new FileReader("D://hocsinh.txt"));
            byte[] receive_data = new byte[1024];
            DatagramPacket packet_receive = new DatagramPacket(receive_data, receive_data.length);
            server.receive(packet_receive);
            String a = new String(packet_receive.getData(), 0, packet_receive.getLength());
            System.out.println("server nhan:" + a);
            String[] b = a.split(" ");
            String kq = "";
            String c = br.readLine();
            if (b[0].equals("1")) {
                while (c != null) {
                    kq += c + "\n";
                    c = br.readLine();
                }
            } else if (b[0].equals("2")) {
                while (c != null) {
                    String[] s = c.split(" ");
                    if (Float.parseFloat(s[4]) > 8) {
                        kq += c + "\n";
                    }else {
                        kq ="khong co hoc sinh gioi nao!";
                    }
                    c = br.readLine();
                }
            } else if (b[0].equals("3")) {
                String infoNewStudent = "";
                while (c != null) {
                    String[] s = c.split(" ");
                    if(s[0].equals(b[2])) {
                        infoNewStudent+=s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+b[3]+"\n";
                    }else {
                        infoNewStudent+=c+"\n";
                    }
                    c = br.readLine();
                }

//                deleteFile();
                createFile(infoNewStudent);
                kq="Server da sua diem";
            }
            br.close();
            byte[] send_data = kq.getBytes();
            DatagramPacket send_pack = new DatagramPacket(send_data, send_data.length, packet_receive.getAddress(), packet_receive.getPort());
            server.send(send_pack);
        }
    }
    
//    public static void deleteFile(){
//        try {
//            File file = new File("D://hocsinh.txt");
//            if(file.exists()){
//                if (file.delete()) {
//                    System.out.println(file.getName() + " is deleted!");
//                } else {
//                    System.out.println("Delete operation is failed.");
//                }
//            }else {
//                System.out.println("khong ton tai file");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public static void createFile(String s) throws IOException{
        File file=new File("D://hocsinh.txt");
        
        if(!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
    }
}
