import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket client = new Socket("localhost", 8);
        DataInputStream dt = new DataInputStream(client.getInputStream());
        DataOutputStream dto = new DataOutputStream(client.getOutputStream());
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập từ gửi cho server: ");
            String s;

            //Gửi dữ liệu
            s = sc.nextLine();
            dto.writeUTF(s);

            //Đọc tin từ server
            if (s.equals("Tam biet")) {
                break;
            }

            String kq = dt.readUTF();
            if (kq.equals("Tam biet")) {
                break;
            } else {
                System.out.println("Client Nhận: " + kq);
            }

        }
    }
}
