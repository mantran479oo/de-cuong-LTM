/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1_7_6_2021;

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
            //lay the dang ki
            Registry reg = LocateRegistry.getRegistry("localhost" ,3232);
            
            RMIInterface server_remote = (RMIInterface) reg.lookup("server");
            System.out.println("Client nhap vao mot so");
            Scanner scanner=new Scanner(System.in);
            int so = scanner.nextInt();
            String kq = server_remote.checkSoChan(so);
            System.out.println("cac uoc so cua "+so+" la"+kq);

    }
}
