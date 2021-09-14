import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(7);
        System.out.println("da ket noi");
        byte[] recieve_data = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(recieve_data, recieve_data.length);
        server.receive(dp1);
        String s = new String(dp1.getData(), 0, dp1.getLength());
        System.out.println("server nhan:" + s);
        ArrayList<thisinh> arr_thisinh = new ArrayList<thisinh>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Documents\\Thisinh.txt"));
        String line = br.readLine();
        thisinh n;
//        while (line != null) {
//           String[] k = line.split("\\$");
//           System.out.println(k[0] + " " + k[1] + k[2]);
//          n = new thisinh(Integer.parseInt(k[1]), Float.parseFloat(k[2]), Boolean.parseBoolean(k[3]));
//            arr_thisinh.add(n);
//           line = br.readLine();
//        }
//        DataOutputStream oos = new DataOutputStream(new FileOutputStream("C:\\Users\\ADMIN\\Documents\\Thisinh.txt"));
        String[] a = s.split(" ");
        String send_text = "";
        if (a[0].equals("1")) {
            for (thisinh n1 : arr_thisinh) {
                if (Integer.parseInt(a[0]) == n1.hoten) {
                    send_text = n1.hoten + " " + n1.adress + " " + n1.cmt + " " + n1.diem1 + " " + n1.diem2 + " " + n1.diem3 + " ";
                }
            }
        } else if (a[0].equals("2")) {
            int diem = 0;
            for (thisinh n2 : arr_thisinh) {
                diem = (n2.diem1 * 2) + n2.diem2 + n2.diem3;
                if (diem >= 30) {
                    send_text = "hien thi danh sach trung tuyen";
                    send_text += line;
                    line = br.readLine();

                }
            }


        } else if(a[0].equals("3")){
            while (line != null) {
                send_text += line + "\n";
                line = br.readLine();
            }
        }
//      oos.close();
        br.close();
        byte[] send_data = send_text.getBytes();
        DatagramPacket dp2 = new DatagramPacket(send_data, send_data.length, dp1.getAddress(), dp1.getPort());
        server.send(dp2);
    }
}
