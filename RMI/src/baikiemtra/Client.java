/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baikiemtra;

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
                System.out.println("1.Tim tu day du"); 
                System.out.println("2.Tim tu viet tat");
                int luachon = scanner.nextInt();
                switch(luachon) {
                    case 1: {
                        System.out.println("nhap tu viet tat");
                        String tu = scanner.next();
                        System.out.println(server_remote.chuyenVietTatSangDayDu(tu) );
                        break;
                    }
                    case 2: {
                        scanner.nextLine();
                        System.out.println("nhap tu day du");
                        String tu = scanner.nextLine();
                        System.out.println(server_remote.chuyenDayDuSangVietTat(tu) );
                        break;
                    }
                }
            }
    }
}
