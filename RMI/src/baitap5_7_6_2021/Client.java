/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap5_7_6_2021;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client implements Serializable{
    public static void main(String[] args) throws RemoteException, NotBoundException {
            Scanner scanner=new Scanner(System.in);
            //lay the dang ki
            Registry reg = LocateRegistry.getRegistry("localhost" ,3232);
            
            RMIInterface server_remote = (RMIInterface) reg.lookup("server");
            while (true) {            
                System.out.println("==========MENU=============");
                System.out.println("1.Hien thi danh sach hoc sinh"); 
                System.out.println("2.Hien thi danh sach hoc sinh gioi");
                System.out.println("3.Nhap diem cho hoc sinh");
                System.out.println("Chon chuc nang");
                int luachon = scanner.nextInt();
                switch(luachon) {
                    case 1: {
                        System.out.println(server_remote.danhSachHocSinh() );
                        break;
                    }
                    case 2: {
                        System.out.println(server_remote.danhSachHocSinhHocBong() );
                        break;
                    }
                    case 3: {
                        System.out.println("Nhap id hoc sinh");
                        int id = scanner.nextInt();
                        System.out.println("id "+id);
                        System.out.println("nhap diem cho hoc sinh");
                        float diemTongKet = scanner.nextFloat();
                        System.out.println("diemTongKet "+diemTongKet);
                        System.out.println(server_remote.nhapDiem(diemTongKet ,id));
                        break;
                    }
                }
            }
    }
}
