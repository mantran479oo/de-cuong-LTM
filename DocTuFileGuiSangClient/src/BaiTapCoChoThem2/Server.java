/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp_menu_file;

import java.io.BufferedReader;
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
    public static void main(String[] args) throws SocketException, IOException{
            DatagramSocket server= new DatagramSocket(3232);
            BufferedReader br= new BufferedReader(new FileReader("D://nhanvien1.txt"));
            byte[] receive_data= new byte[1024];
            DatagramPacket packet_receive= new DatagramPacket(receive_data, receive_data.length);
            server.receive(packet_receive);
            String a= new String(packet_receive.getData(), 0,packet_receive.getLength());
            System.out.println("server nhan:"+ a);
            String[] b= a.split(" ");
            String kq="";
            String c=br.readLine();
            if(b[0].equals("1")){
                while(c!=null){ 
                    String[] s= c.split(" ");
                    if(s[1].equals(b[1])){
                        kq+=c+"\n";
                    }
                    c= br.readLine();
                }
            }
            else{
                while(c!=null){
                        kq+=c;
                        c= br.readLine();
                }
            }
            br.close();
            byte[] send_data= kq.getBytes();
        DatagramPacket send_pack= new DatagramPacket(send_data, send_data.length,packet_receive.getAddress(), packet_receive.getPort());
        server.send(send_pack);
    }

}
