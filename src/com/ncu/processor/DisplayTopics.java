package com.ncu.processor;
import java.io.*;
import java.io.IOException;

public class DisplayTopics { 

  private String currentLine;
  BufferedReader br; 
  public void readFile(String fileName) throws IOException { 
  br = new BufferedReader(new FileReader(fileName));
  while ((currentLine = br.readLine()) != null) { 
  System.out.println(currentLine); 
  }
 }
}
class DisplayTopicsTest {
    public static void main(String[] args) {

    DisplayTopics r1 = new DisplayTopics();
    String fileName = "C:\\Users\\AKASH\\Desktop\\Major\\csvs\\topic.csv";

    try {
        r1.readFile(fileName);
    } catch (IOException e) {
        System.out.println("file not found");
    }
 }

}