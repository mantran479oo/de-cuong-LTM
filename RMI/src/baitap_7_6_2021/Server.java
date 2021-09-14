/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap_7_6_2021;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vuan
 */
public class Server extends UnicastRemoteObject implements RMIInterface{
    public Server() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(3232);
        registry.rebind("server", this);
    }
    
    public static void main(String[] args) throws RemoteException {
        Server s = new Server();
    }

    @Override
    public int timUocSo(int a) throws RemoteException {
        int soUoc = 0;
        for (int i = 1; i <= a; i++) {
            if(a % i == 0) {
                soUoc++;
            }
        }
        return soUoc;
    }
    
}
