/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quan_Li_Ngan_Hang;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 3232);
        Quan_li_ngan_hang server = (Quan_li_ngan_hang) reg.lookup("server");
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        while (status) {
            System.out.println("======Menu====");
            System.out.println("1. Chuyển tiền\n 2.Rút tiền\n 3.Xem số dư\n 4.Xem lịch sử giao dịch\n 5.Thoát chương trình");
            System.out.print("Nhap lưa chon: ");
            int c =  sc.nextInt();
            int n=0;
            switch(c){
            case 1:
                System.out.println("Nhập số tiền cần chuyển: ");
                n = sc.nextInt();
                System.out.println("***Số dư tại thời điểm giao dịch: "+server.chuyentien(n));
                break;
            case 2:
                System.out.println("Nhập số tiền cần rút: ");
                n = sc.nextInt();
                System.out.println("***Số dư tại thời điểm giao dịch: "+server.ruttien(n));
                break;
            case 3:
                System.out.println("***Số dư tài khoản: "+server.xemsodu());
                break;
            case 4:
                System.out.println("***Lịch sử giao dịch: "+server.xemlichsu());
                break;
            case 5:
                status = false;
                break;
        }
        }
    }
}
