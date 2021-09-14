/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baikiemtra;

import init.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
            
            int kq  = dis_server.readInt();
            System.out.println("server nhan "+ kq);
            int traVe = kq*kq;
            dos_server.writeInt(traVe);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
