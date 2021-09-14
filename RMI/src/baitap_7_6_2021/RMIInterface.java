/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap_7_6_2021;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author vuan
 */
public interface RMIInterface extends Remote{
    public int timUocSo(int a) throws RemoteException;
}
