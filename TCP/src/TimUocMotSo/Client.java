/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimUocMotSo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 7777);
        System.out.println("Client say hi");
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so: ");
        int num = Integer.parseInt(sc.nextLine());
        dos.writeInt(num);
        System.out.println("UCLN cua " + num + "\n" + dis.readUTF());
        
    }
}
