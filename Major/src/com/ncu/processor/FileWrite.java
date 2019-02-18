package com.ncu.processor;
import com.ncu.validators.*;
import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class FileWrite {
   
   public static void topic() {
      Scanner sc=new Scanner(System.in);
      //creating a scanner object

      boolean b;
      TopicNameValidator a = new TopicNameValidator();
      System.out.println("Enter Topic : ");
      //asking the user to enter the topics
      String str=sc.nextLine();
      b = a.topicNameValidator(str);
      if(b==true)
      {
        //specifying path for the string
      String txtfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\Text";
      String csvfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\csvs\\topic.csv";
      
      try {
         

         CSVWriter writer = new CSVWriter(new FileWriter(csvfilepath));
         System.out.println("enter no. of Coloumn");
         int noCols=sc.nextInt();
         String[] inData= new String[noCols];
         StringBuilder sb = new StringBuilder();
         
           //stringbuilder is used to modify strings

           //append is used to join strings
  
         for (int i=0;i<noCols ;i++ ) {
               System.out.println(i+"\n");
            inData[i] = sc.next();
            sb.append(inData[i]).append(",");

            
            File f = new File(str);
            FileWriter fout = new FileWriter(txtfilepath+"\\"+f);
            BufferedWriter bout= new BufferedWriter(fout);

            
         System.out.print("Enter a String: ");
      
         while(sc.hasNext()){
              bout.write(sc.nextLine());  
              bout.newLine();         
            }
         
             bout.close();

        writer.writeNext(inData);
      writer.close();
    }


             
      }
       catch (Exception e) {
         
         e.printStackTrace();
      }
   }
      }
      
}