/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap3_7_6_2021;

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
        Scanner scanner = new Scanner(System.in);
        //lay the dang ki
        Registry reg = LocateRegistry.getRegistry("localhost", 3232);

        RMIInterface server_remote = (RMIInterface) reg.lookup("server");
        System.out.println("Client nhap vao mot so thu nhat");
        int so1 = scanner.nextInt();
        System.out.println("Client nhap vao mot so thu hai");
        int so2 = scanner.nextInt();
        System.out.println("===========MENU============");
        System.out.println("1.Tinh tong hai so");
        System.out.println("2.Tinh hieu hai so");
        int luaChon = scanner.nextInt();
        switch (luaChon) {
            case 1: {
                System.out.println("Tong hai so la:"+server_remote.tongHaiSo(so1, so2)) ;
                break;
            }
            case 2: {
                System.out.println("Hieu hai so la:"+server_remote.hieuHaiSo(so1, so2)) ;
                break;
            }    
        }

    }
}
