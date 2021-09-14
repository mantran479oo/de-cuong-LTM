/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TCP_trac_nghiem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author nhu
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket my_client= new Socket("localhost", 7);
        int check=0;
        Scanner sc= new Scanner(System.in);
        DataInputStream dis= new DataInputStream(my_client.getInputStream());
        DataOutputStream dos= new DataOutputStream(my_client.getOutputStream());
        while(true){
             if(check==0){
                 dos.writeUTF("Start");
            }
            else{
                System.out.println("Nhap dap an:");
                dos.writeUTF(sc.nextLine()); 
            }
             System.out.println(dis.readUTF());
             check++;
             if(check==4){
                 break;
             }
        }
        dis.close();
        dos.close();
        my_client.close();
    }
}
