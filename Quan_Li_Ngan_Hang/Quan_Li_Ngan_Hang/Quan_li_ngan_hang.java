/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quan_Li_Ngan_Hang;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Administrator
 */
public interface Quan_li_ngan_hang extends Remote{
    public int chuyentien(int n) throws RemoteException;
    public int ruttien(int n) throws RemoteException;
    public int xemsodu() throws RemoteException;
    public String xemlichsu() throws RemoteException;
}
