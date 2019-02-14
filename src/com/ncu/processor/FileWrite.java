import java.io.*;
import java.util.*;


class FileWrite {
   
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter name of File : ");
      String str=sc.nextLine();

      String txtfilepath = "C:\\Users\\AKASH\\Desktop\\Major\\Text";
      String csvfilepath = "C:\\Users\\AKASH\\Desktop\\Major\\csvs";
      
      try {
         
            File f = new File(str);
            FileWriter fout = new FileWriter(txtfilepath+"\\"+f);
			      BufferedWriter bout= new BufferedWriter(fout);

            
 			   System.out.print("Enter a String: ");
 			
 			   while(sc.hasNext()){
              bout.write(sc.nextLine());  
              bout.newLine();         
            }
         
             bout.close();
             
			}
       catch (Exception e) {
         
         e.printStackTrace();
      }
   }
}