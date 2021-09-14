/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaiTapCoChoThem19_4;

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
            BufferedReader br = new BufferedReader(new FileReader("D://nha.txt"));
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
            }else if (b[0].equals("2")) {
                if(b[2].equals("1")){
                    System.out.println("tim theo so nha");
                    while (c != null) {
                        String[] s = c.split(" ");
                        if(s[0].equals(b[3])){
                            System.out.println("trung so nha");
                            kq+=c+"\n";
                        }              
                        c = br.readLine();
                    }
                }else if(b[2].equals("2")){
                    System.out.println("tim theo tinh trang");
                    while (c != null) {
                        String[] s = c.split(" ");
                        //System.out.println(s[2]+" | "+b[3]);
                        if(s[2].equals(b[3])){
                            kq+=c+"\n";
                        }
                        if(!s[2].equals(b[3])) {
                            kq = "khong co ket qua";
                        }
                        c = br.readLine();
                    }
                }
            }
            else if (b[0].equals("3")) {
                String newHome = "";
                while (c != null) {
                    newHome += c+"\n";
                    c = br.readLine();
                }
                newHome += b[2]+" "+b[3]+" "+"false";
                createFile(newHome);
                kq="da them thanh cong";
            }else if (b[0].equals("4")) {
                String muaNha = "";
                while (c != null) {
                    String[] s = c.split(" ");
                    if(s[0].equals(b[2])) {
                        if(s[2].equals("true")){
                            kq="nha da bi mua";
                        }else {
                            muaNha+=s[0]+" "+s[1]+" "+"true"+"\n";
                            kq = "da mua thanh cong";
                        }
                    }else {
                        muaNha+=c+"\n";
                    }
                    c = br.readLine();
                }
                createFile(muaNha);
                
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
        File file=new File("D://nha.txt");
        
        if(!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
    }
}
