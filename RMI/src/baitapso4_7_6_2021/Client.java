/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4_7_6_2021;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
            Scanner scanner=new Scanner(System.in);
            //lay the dang ki
            Registry reg = LocateRegistry.getRegistry("localhost" ,3232);
            
            RMIInterface server_remote = (RMIInterface) reg.lookup("server");
            while (true) {            
                System.out.println("==========MENU=============");
                System.out.println("1.Chuyen tien"); 
                System.out.println("2.Rut tien khoi tai khoan");
                System.out.println("3.Xem so du");
                System.out.println("4.Xem lich su giao dich");
                System.out.println("Chon chuc nang");
                int luachon = scanner.nextInt();
                switch(luachon) {
                    case 1: {
                        System.out.println("nhap so tien");
                        float soTien = scanner.nextFloat();
                        System.out.println(server_remote.napTien(soTien) );
                        break;
                    }
                    case 2: {
                        System.out.println("nhap so tien");
                        float soTien = scanner.nextFloat();
                        System.out.println(server_remote.rutTien(soTien) );
                        break;
                    }
                    case 3: {
                        System.out.println(server_remote.xemSoDu());
                        break;
                    }
                    case 4: {
                        System.out.println(server_remote.lichSuGiaoDich());
                        break;
                    }
                }
            }
    }
}
