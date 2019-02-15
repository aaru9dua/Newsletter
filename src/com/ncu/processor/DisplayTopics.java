package com.ncu.processor;
import java.io.*;
import java.io.IOException;
import com.ncu.processor.*;

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