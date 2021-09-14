/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimUocMotSo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vuan
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(7777);
        Socket server = socket.accept();
        System.out.println("Server say hi");
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        int getNum = dis.readInt();
        String result = UocCuaMotSo(getNum);
        dos.writeUTF(result);

    }

    public static String UocCuaMotSo(int num) {
        String result = "";
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                result += Integer.toString(i) + " ";
            }
        }
        return result;
    }
}
