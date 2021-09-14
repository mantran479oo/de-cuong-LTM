/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//he thong luu tru cau hoi trach nhiem
//co nhieu cau tra loi
//tro choi ket thuc khi client hoan thanh 20 cau hoi
//hoac tra loi phim T

import java.io.*;
import java.net.*;

/**
 *
 * @author mhieu
 */
public class serve10_cauhoitoanhoc {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(7777);
        Socket server = socket.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        System.out.println(dis.readUTF());
        dos.writeUTF("Hello client! Ban co muon tra loi cau do toan hoc?\n"
                + "Nhap \"t\" de thoat khoi tro choi");
        String start = dis.readUTF();
        System.out.println(start);
        if(start.equals("t")) return;
        int playing = 0, score = 0;
        while(playing++ < 20){
            System.out.println("Bat dau choi");
            
            String[] answerQuestion = CauDoToanHoc(playing);
            dos.writeUTF("Cau " + playing + " " + answerQuestion[0]);
            System.out.println("Cau " + playing + " " + answerQuestion[0]);
            String answer = dis.readUTF();
            System.out.println("Question la " + answer);
            if(answer.toUpperCase().equals("t") || answer.toUpperCase().equals(("T"))) break;            
            if(answer.toUpperCase().equals(answerQuestion[1])){
                dos.writeUTF("Ban tra loi chinh xac");
                score++;
            }else{
                dos.writeUTF("Dap an chinh xac la: " + answerQuestion[1]);
            }
            dis.readUTF();
//            dos.writeUTF("Ban co muon tiep tuc");
//            System.out.println("Ban co muon tiep tuc");
//            System.out.println(answerQuestion[0] + answerQuestion[1]);
        }
        dos.writeUTF("Ban dat duoc " + score + " diem" + "\nBye bye");
        server.close();
        
        
    }

    public static String[] CauDoToanHoc(int number) throws FileNotFoundException, IOException {
        String[] result = new String[2];
        FileReader fr = new FileReader("D:\\cauhoitoanhoc.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        for(int i = 0; i < number - 1; i++){
            line = br.readLine();
//            System.out.println(i);
        }
        String[] s = line.split(" ");
        result[0] = s[0] + " \tA." + s[1] + "\tB." + s[2]
                + "\tC." + s[3] + "\tD." + s[4];
        result[1] = s[5];
        br.close();
        fr.close();
        return result;

    }
}
