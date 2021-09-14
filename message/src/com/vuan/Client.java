/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author vuan
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket myclient = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so thu 1 :");
        String a1 = sc.nextLine();
        System.out.println("nhap so thu 2 :");
        String a2 = sc.nextLine();
        byte[] send_data1 =a1.getBytes();
        byte[] send_data2 =a2.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket send_pack1  = new DatagramPacket(send_data1, send_data1.length, ip, 7);
        myclient.send(send_pack1 );
        DatagramPacket send_pack2  = new DatagramPacket(send_data2, send_data2.length, ip, 7);
        myclient.send(send_pack2 );
        byte[] receive_data = new byte[1024];
        DatagramPacket pack_receive = new DatagramPacket(receive_data, receive_data.length);
        myclient.receive(pack_receive);
        System.out.println("Client nhan kq tu server:"+new String(pack_receive.getData()));
    }
    
}

/*
public class Client {
	public static void main(String[] args) throws UnknownHostException {
		try {
			DatagramSocket myClient = new DatagramSocket();
			Scanner scanner =new Scanner(System.in);
			System.out.println("Nhap so nguyen dau tien :");
			String a = scanner.nextLine();
			System.out.println("Nhap so nguyen thu hai :");
			String b = scanner.nextLine();
			
			
	        //gui ve cho server
			
			//gui so thu 1
			byte [] sendData = a.getBytes();
			InetAddress ipAddress = InetAddress.getByName("localhost");
			DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length,ipAddress,10);
			myClient.send(datagramPacket);
			
			//gui so thu 2
			byte [] sendData2 = b.getBytes();
			InetAddress ipAddress2 = InetAddress.getByName("localhost");
			DatagramPacket datagramPacket2 = new DatagramPacket(sendData2, sendData2.length,ipAddress,10);
			myClient.send(datagramPacket2);
			
			//nhan tu server
		    byte[] receiveData = new byte[1024];
		    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		    myClient.receive(receivePacket);
			String s = new String(receivePacket.getData());
			System.out.println(s);
			myClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
*/