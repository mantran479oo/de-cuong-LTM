/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt_14_6_2021_ketnoiCSDL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, IOException {
        Socket client = new Socket("localhost", 7777);
        Scanner scanner = new Scanner(System.in);
        //lay the dang ki
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        while (true) {
            System.out.println("==========MENU=============");
            System.out.println("1.Hien thi danh sach hoc sinh");
            System.out.println("2.Hien thi danh sach hoc sinh gioi");
            System.out.println("3.Nhap diem cho hoc sinh");
            System.out.println("Chon chuc nang");
            int luachon = scanner.nextInt();
            switch (luachon) {
                case 1: {
                    dos.writeUTF(String.valueOf(luachon));
                    break;
                }
                case 2: {
                    dos.writeUTF(String.valueOf(luachon));
                    break;
                }
                case 3: {
                    System.out.println("Nhap id hoc sinh");
                    int id = scanner.nextInt();
                    System.out.println("nhap diem cho hoc sinh");
                    float diemTongKet = scanner.nextFloat();
                    dos.writeUTF(luachon + " " + id + " " + diemTongKet);
                    break;
                }
            }
            System.out.println("client nhan \n" + dis.readUTF());
        }
    }
}
