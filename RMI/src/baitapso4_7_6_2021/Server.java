/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4_7_6_2021;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author vuan
 */
public class Server extends UnicastRemoteObject implements RMIInterface{
    float soDu = 0;
    String history = "";
    
    public Server() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(3232);
        registry.rebind("server", this);
    }
    
    public static void main(String[] args) throws RemoteException {
        Server s = new Server();
    }

    @Override
    public String napTien(float soTien) throws RemoteException {
        soDu += soTien;
        history += "Nap "+soTien+" vao tai khoan\n";
        return "Nap tien thanh cong";
    }

    @Override
    public String rutTien(float soTien) throws RemoteException {
        if(soDu >= soTien){
            soDu -= soTien;
            history += "Rut "+soTien+" khoi tai khoan\n";
            return "Rut tien thanh cong";
        }
        return "so du khong du";
    }

    @Override
    public String xemSoDu() throws RemoteException {
        return "Tai khoan cua ban hien co "+String.valueOf(soDu+" dong");
    }

    @Override
    public String lichSuGiaoDich() throws RemoteException {
        return history;
    }

    
    
}
