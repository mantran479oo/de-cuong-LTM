/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4_7_6_2021;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vuan
 */
public interface RMIInterface extends Remote{
    public String napTien(float soTien) throws RemoteException;
    
    public String rutTien(float soTien) throws RemoteException;
    
    public String xemSoDu() throws RemoteException;
    
    public String lichSuGiaoDich() throws RemoteException;
}
