/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaiTapCoChoThem19_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author nhu
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        Scanner sc= new Scanner(System.in);
        String kq="";
        while (true) {
            System.out.println("=================Menu====================");
            System.out.println("1.Hien thi tat ca nha");
            System.out.println("2.Tim kiem");
            System.out.println("3.Them nha");
            System.out.println("4.Mua nha");
            System.out.println("5.Thoat");
            int luaChon= Integer.parseInt(sc.nextLine());
            if (luaChon == 1) {
                kq = luaChon + " showall ";
                send_receive(kq);
            }
            if (luaChon == 2) {
                System.out.println("1.tim kiem theo so nha");
                System.out.println("2.tim kiem theo tinh trang");
                int search = Integer.parseInt(sc.nextLine());
                if(search == 1){
                    System.out.println("nhap so nha muon tim kiem");
                    int soNha = Integer.parseInt(sc.nextLine());
                    kq = luaChon + " timkiem "+search+" "+soNha;
                }if(search == 2){
                    System.out.println("nhap tinh trang");
                    String tinhTrang = sc.nextLine();
                    kq = luaChon + " timkiem "+search+" "+tinhTrang;
                }
                send_receive(kq);
            }
            if (luaChon == 3) {
                System.out.println("nhap so nha");
                int soNha = Integer.parseInt(sc.nextLine());
                System.out.println("nhap gia nha");
                int giaNha = Integer.parseInt(sc.nextLine());
                kq = luaChon + " themnha "+soNha+" "+giaNha;
                send_receive(kq);
            }
            if (luaChon == 4) {
                System.out.println("Chon so nha");
                int soNha = Integer.parseInt(sc.nextLine());
                kq = luaChon + " muanha "+soNha;
                send_receive(kq);
            }if(luaChon == 5){
                break;
            }
        }

        
        
        
    
    }
    
    public static void send_receive(String kq) throws UnknownHostException, IOException{
        DatagramSocket client = new DatagramSocket();
        byte[] send_data = kq.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket send_pack = new DatagramPacket(send_data, send_data.length, ip, 3232);
        client.send(send_pack);

        byte[] receive_data = new byte[1024];
        DatagramPacket packet_receive = new DatagramPacket(receive_data, receive_data.length);
        client.receive(packet_receive);
        String a = new String(packet_receive.getData(), 0, packet_receive.getLength());
        System.out.println("\n"+a);
    }
    
}
