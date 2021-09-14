package bt_24_5_2021_bai6diem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhieu
 */
public class Client {
   public static void main(String[] args) throws IOException, ClassNotFoundException{
       System.out.println("client say hi");
       Socket client = new Socket("localhost", 7777);
//       DataInputStream  dis = new DataInputStream(client.getInputStream());
//       ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
       InputStream is = client.getInputStream();
       ObjectInputStream ois = new ObjectInputStream(is);
       DataOutputStream dos = new DataOutputStream(client.getOutputStream()); 
       Scanner sc = new Scanner(System.in);
       System.out.println("1.Nhap ten de tim kiem thi sinh");
       System.out.println("2.Hien thi toan bo thi sinh");
       String luaChon = sc.nextLine();
       //send to server
       dos.writeUTF(luaChon);
       
       //receive from client
       List<ThiSinh> listThiSinhs = new ArrayList<ThiSinh>();
       ThiSinh thiSinh;
       listThiSinhs = (List<ThiSinh>) ois.readObject();
       thiSinh = listThiSinhs.get(0);
       System.out.println("Thong tin sinh vien");
       System.out.println(thiSinh.toString());
//       ois.close();
       dos.close();
       client.close();
   }
}
