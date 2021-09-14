import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        System.out.println("Da ket noi!!!!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Tim kiem\n2.Hien thi danh sach trung tuyen\n3.Hien thi toan bo thong tin thi sinh");
        System.out.println("Moi chon:");
        int chon = sc.nextInt();
        String kq="";
        String send_text = "";
        switch (chon) {
            case 1: {
                System.out.println("Moi nhap ho ten:");
                int hoten = sc.nextInt();
                send_text = chon + " " + hoten + " ";
                break;
            }
            case 2: {
              send_text=chon+"Danh sach thi sinh trung tuyen: ";
                break;

            }
            case 3: {
                send_text=chon+ " Danh sach thi sinh";
                break;
            }
            default: {
                System.out.println("moi nhap lai!!!!");
            }
        }
        byte[] send_data = send_text.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket dp1 = new DatagramPacket(send_data, send_data.length, ip, 7);
        client.send(dp1);
        byte[] recieve_data = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(recieve_data, recieve_data.length);
        client.receive(dp2);
        String s = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println(s);
    }
}
