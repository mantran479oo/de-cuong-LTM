/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baikiemtra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public String chuyenVietTatSangDayDu(String vietTat) throws RemoteException {
        System.out.println("server nhan"+vietTat);
        String kq= "";
        String temp = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("D://word.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                if(s[0].equals(vietTat))
                    temp = s[1];
                    String[] tu = temp.split("\\$");
                    for (int j = 0; j < tu.length; j++) {
                        kq+=tu[j]+" ";
                    }
                    line = br.readLine();
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public String chuyenDayDuSangVietTat(String dayDu) throws RemoteException {
        System.out.println("server nhan"+dayDu);
//        String kq= "";
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("D://word.txt"));
//            String line = br.readLine();
//            while (line != null) {
//                String[] s = line.split(" ");
//                if(s[1].equals(dayDu))
//                    kq = s[0];
//                    line = br.readLine();
//                }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return kq;
        String kq= "";
        String check= "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("D://word.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                String g =s[1];
                String[] tu = g.split("\\$");
                
                for (int i = 0; i < tu.length; i++) {
                    System.out.println(tu[i]);
                    check+=tu[i]+" ";
                }
                check = check.trim();
                System.out.println("check"+check.trim());
                if(check.equals(dayDu))
                    kq = s[0];
                    line = br.readLine();
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

}
