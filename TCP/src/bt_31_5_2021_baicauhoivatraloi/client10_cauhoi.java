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
public class client10_cauhoi {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 7777);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        Scanner sc = new Scanner(System.in);
        dos.writeUTF("Hello Server");
        System.out.println(dis.readUTF());
        dos.writeUTF(sc.nextLine());
        int keepPlay = 1;
        while(keepPlay > 0){
//            System.out.println(dis.readUTF());
//            dos.writeUTF(sc.nextLine());
            System.out.println(dis.readUTF());
            String keep = sc.nextLine();
            if(keep.equals("T") || keep.equals("t")) keepPlay = 0;
            dos.writeUTF(keep);
            System.out.println(dis.readUTF());
            
        }
    }
}
