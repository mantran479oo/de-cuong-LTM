/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;

/**
 *
 * @author mhieu
 */
public class Server {
    public static void main(String[] args) throws IOException{
        System.out.println("Server say hi");
        ServerSocket socket = new ServerSocket(7777);
        Socket server = socket.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        String recvStr = dis.readUTF();
        String result = "";

        if(recvStr.equals("yes")||recvStr.equals("y")){
            FileReader fr = new FileReader("D:\\sinhvien.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line !=null){
                String[] s = line.split("\\$\\$");
                result += "\n\t" + s[0] + " " + s[1];
                line = br.readLine();
            }
        }
        System.out.println(result);
        dos.writeUTF(result);
        
            
        
    }
}
