/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author vuan
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket myserver = new DatagramSocket(7);
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myserver.receive(pack_receive);
        int s1 = Integer.parseInt(new String(pack_receive.getData(),0, pack_receive.getLength()));
        System.out.println("Server nhan so 1:"+s1);
        int s2 = Integer.parseInt(new String(pack_receive.getData(),0, pack_receive.getLength()));
        System.out.println("Server nhan so 2:"+s2);
        String a = String.valueOf(s1+s2);
        byte[] send_data = a.getBytes();
        DatagramPacket send_packet = new DatagramPacket(send_data, send_data.length, pack_receive.getAddress(), pack_receive.getPort());
        myserver.send(send_packet);
    }
}

/*
public class Server {
	public static void main(String[] args) throws IOException {
		try {
			DatagramSocket myServer =new DatagramSocket(10);
			
			//nhan tu client
			//nhan so thu 1
		    byte[] receiveData = new byte[1024];
		    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		    myServer.receive(receivePacket);
			String s = new String(receivePacket.getData(),0,receivePacket.getLength());
			System.out.println("Client gui so thu 1 :"+s);
			
			//nhan so thu 2
		    byte[] receiveData2 = new byte[1024];
		    DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
		    myServer.receive(receivePacket2);
			String s2 = new String(receivePacket2.getData(),0,receivePacket2.getLength());
			System.out.println("Client gui so thu 2 :"+s2);
			
			//tra ve cho client
			int sendData = Integer.parseInt(s);
			int sendData2 = Integer.parseInt(s2);
			int tong = sendData+ sendData2;
			String tongString = String.valueOf("Tong 2 so vua nhap la :"+tong);
            
			
			InetAddress ipAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			byte[] sendByte = tongString.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length,ipAddress,port);
			myServer.send(sendPacket);
			myServer.close();

		} catch (SocketException e) {
			
			e.printStackTrace();
		}

		}
}
*/