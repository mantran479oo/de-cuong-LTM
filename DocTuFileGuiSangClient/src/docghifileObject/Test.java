/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docghifileObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author vuan
 */
public class Test {
    public static void main(String[] args) throws IOException {
        
        try {
            File file = new File("D://hocsinh.txt");
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        File file=new File("D://test.txt");
//        
//        if(!file.exists()) {
//            file.createNewFile();
        }
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        String s = "hi hello\nAn";
//        fileOutputStream.write(s.getBytes());
//        fileOutputStream.close();

//        FileInputStream fileInputStream = new FileInputStream(file);
//        int c = fileInputStream.read();
//        while (c != -1) {            
//            System.out.print((char) c);
//            c = fileInputStream.read();
//        }
//        fileInputStream.close();
//        
//        System.out.println("\ndoc thanh cong");
    
    
//    public static class Person {
//        int id;
//        String name;
//
//        public Person() {
//        }
//
//        public Person(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }   
//    }
}

