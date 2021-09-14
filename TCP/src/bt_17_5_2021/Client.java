/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author mhieu
 */
public class Client {
   public static void main(String[] args) throws IOException{
       System.out.println("Client say hi");
       Socket client = new Socket("localhost", 7777);
       DataInputStream  dis = new DataInputStream(client.getInputStream());
       DataOutputStream dos = new DataOutputStream(client.getOutputStream());
       Scanner sc = new Scanner(System.in);
       System.out.println("Gui thong tin sinh vien\n1.Yes hoac y\n2.No");
       String strScan = sc.nextLine();
       dos.writeUTF(strScan);
       System.out.println("Thong tin sinh vien");
       System.out.println(dis.readUTF());
       
       dis.close();
       dos.close();
       client.close();
   }
}
