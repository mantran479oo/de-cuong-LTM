/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import init.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vuan
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket myServer = new ServerSocket(8);
            
            Socket socketClient = myServer.accept();
            DataInputStream dis_server =  new DataInputStream(socketClient.getInputStream());
            DataOutputStream dos_server = new DataOutputStream(socketClient.getOutputStream());
            
            int receive  = dis_server.readInt();
            if(receive == 1){
                BufferedReader reader = new BufferedReader(new FileReader("D:\\sinhvien.txt"));
                String line = reader.readLine();
                String kq="";
                while (line != null) {
                        String[] info = line.split(" ");
                        System.out.println(info[0] + " " + info[1]+" "+info[2]);
                        kq += info[0] + " " + info[1] + " " + info[2] + "\n";
                        line = reader.readLine();
                    }
                reader.close();
                System.out.println("kq "+kq);
                dos_server.writeUTF(kq);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
