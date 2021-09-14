/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baikiemtra;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vuan
 */
public interface RMIInterface extends Remote{
    public String chuyenVietTatSangDayDu(String vietTat) throws RemoteException;
    
    public String chuyenDayDuSangVietTat(String dayDu) throws RemoteException;
}
