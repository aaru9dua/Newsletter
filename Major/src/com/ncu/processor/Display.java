package com.ncu.processor;
import java.io.*;
import java.util.*;
public class Display{
     public static void display() {
    String fname;
    Scanner scan = new Scanner(System.in);

    String txtfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\Text";
      String csvfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\csvs";

    // enter filename with extension to open and read its content */

    System.out.print("Enter File Name to Open (with extension like file.txt) : ");
    fname = scan.nextLine();

    // this will reference only one line at a time */

    String line = null;
    try
    {
        /* FileReader reads text files in the default encoding */
        FileReader fileReader = new FileReader(txtfilepath+"\\"+fname);

        /* always wrap the FileReader in BufferedReader */
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null)

            //if the file is not empty, then it will print out its content
        {
            System.out.println(line);
        }

        /* always close the file after use */
        bufferedReader.close();
    }
    catch(IOException ex)
    {
        System.out.println("Error reading file named '" + fname + "'");
    }

   }
}
