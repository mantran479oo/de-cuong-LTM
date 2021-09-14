/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quan_Li_Ngan_Hang;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Server extends UnicastRemoteObject implements Quan_li_ngan_hang{
    private int sodu = 50000;
    private String history = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    
    
    public Server() throws RemoteException{
        Registry regis = LocateRegistry.createRegistry(3232);
        regis.rebind("server", this);
    }

    @Override
    public int chuyentien(int n) throws RemoteException {
        Date date = new Date();
        String time = formatter.format(date);
        sodu += n;
        history += time+" - Chuyển "+n+" vào tài khoản.\n";
        return (sodu);
    }

    @Override
    public int ruttien(int n) throws RemoteException {
        Date date = new Date();
        String time = formatter.format(date);
        sodu -= n;
        history += time+" - Rút "+n+" từ tài khoản.\n";
        return (sodu);
    }

    @Override
    public int xemsodu() throws RemoteException {
        Date date = new Date();
        String time = formatter.format(date);
        history += time+" Xem số dư tài khoản\n";
        return (sodu);
    }
    @Override
    public String xemlichsu() throws RemoteException {
        return history;
    }
    
    
    public static void main(String[] args) throws RemoteException {
        Server sv = new Server();
    }
    
}
