import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8);
        Socket my_server = server.accept();
        DataInputStream dt = new DataInputStream(my_server.getInputStream());
        DataOutputStream dto = new DataOutputStream(my_server.getOutputStream());
        while (true) {

            //Đọc, ktra và gửi dữ liệu
            String kq = dt.readUTF();
            if (kq.equals("Tam biet")) {
                break;
            }else {
                System.out.println("Server Nhận: " + kq);
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập từ gửi cho client: ");
            String s = sc.nextLine();

            //Gửi dữ liệu
            dto.writeUTF(s);

            if (s.equals("Tam biet")) {
                break;
            }
        }
        dt.close();
        dto.close();

        }


    }


