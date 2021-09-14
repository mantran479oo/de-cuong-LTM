/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_24_5_2021_ramdom5cauhoi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vuan
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket my_server= new ServerSocket(7);
        Socket socket= my_server.accept();
        int diem=0, check=0;
        DataInputStream dis= new DataInputStream(socket.getInputStream());
        DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
        String b1=dis.readUTF();
         BufferedReader   br= new BufferedReader(new FileReader("D:\\trac_nghiem_toan.txt"));
        while(true){
            String line= br.readLine();
            if(line==null){
                break;
            }
            String[] b= line.split("\\$");
            dos.writeUTF(b[0]);
            check++;
            if(b[1].equals(dis.readUTF())){
                diem++;
            }
            if(check==3){
                dos.writeUTF("Ban dat duoc so diem:"+ diem);
            }
        }
    }
}
