/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2_7_6_2021;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vuan
 */
public interface RMIInterface extends Remote{
    public String tongHaiSo(int so1 ,int so2) throws RemoteException;
    
    public String hieuHaiSo(int so ,int so2) throws RemoteException;
}
