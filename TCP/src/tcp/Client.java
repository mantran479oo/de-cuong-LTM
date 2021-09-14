/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import init.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        Socket myclient = new Socket("127.0.0.1" ,8);
        
        DataInputStream dis_client = new DataInputStream(myclient.getInputStream());
        DataOutputStream dos_client = new DataOutputStream(myclient.getOutputStream());
        
        System.out.println("1.Hien thi thong tin sinh vien");
        int a = scanner.nextInt();
        dos_client.writeInt(a);
        System.out.println("client nhan :"+dis_client.readUTF()); 
        dis_client.close();
        dos_client.close();
        myclient.close();
    }
    
}
