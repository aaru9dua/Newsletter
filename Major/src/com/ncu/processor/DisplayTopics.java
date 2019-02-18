package com.ncu.processor;
import java.io.*;
import java.io.IOException;
import com.ncu.processor.*;

public class DisplayTopics { 

  public String currentLine;
  BufferedReader br; 
  //buffered reader is used to read lines as a sentence and not as a single character
  public void readFile(String fileName) throws IOException { 
  br = new BufferedReader(new FileReader(fileName));
  while ((currentLine = br.readLine()) != null) { 
  System.out.println(currentLine); 
  }
 }
}