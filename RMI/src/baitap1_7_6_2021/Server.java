/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1_7_6_2021;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

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
    public String checkSoChan(int so) throws RemoteException {
        if(so%2 == 0){
            return "so "+so+" la so chan";
        }
        return "so "+so+" la so le";
    }
    
    
}
