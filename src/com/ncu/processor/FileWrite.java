package com.ncu.processor;
import com.ncu.validators.*;
import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class FileWrite {
   
   public static void topic() {
      Scanner sc=new Scanner(System.in);
      boolean b;
      TopicNameValidator a = new TopicNameValidator();
      System.out.println("Enter Topic : ");
      String str=sc.nextLine();
      b = a.topicNameValidator(str);
      if(b==true){
        String txtfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\Text";
      String csvfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\csvs\\topic.csv";
      
      try {
         
            File f = new File(str);
            FileWriter fout = new FileWriter(txtfilepath+"\\"+f);
            BufferedWriter bout= new BufferedWriter(fout);
            FileWriter fout1 = new FileWriter(csvfilepath);
            BufferedWriter bout2= new BufferedWriter(fout1);

            
         System.out.print("Enter a String: ");
      
         while(sc.hasNext()){
              bout.write(sc.nextLine());  
              bout2.write(sc.nextLine());  
              bout.newLine();         
            }
         
             bout.close();
             
      }
       catch (Exception e) {
         
         e.printStackTrace();
      }
   }
      }
      
}
