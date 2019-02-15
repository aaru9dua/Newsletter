package com.ncu.main;
import com.ncu.processor.*;
import java.util.Scanner;
import java.io.*;
public class Newsletter{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		System.out.println(" available choices: ");
		System.out.println(" \t 1) add a new Topic : ");
		System.out.println(" \t 2) view available Topics");
		System.out.println(" \t 3) Search and display for a file ");
		int c=s.nextInt();	
		switch(c){
			case 1: {//choice1();
					System.out.println("1: Add Topic");
					FileWrite f = new FileWrite();
					f.topic();
					break;
					}
			case 2: {//choice2();
					System.out.println("2: View All Topics");
					DisplayTopics r1 = new DisplayTopics();
                    String fileName = "C:\\Users\\Abhi\\Desktop\\Major\\csvs\\topic.csv";
                    try {
                        r1.readFile(fileName);
                    } 
                    catch (IOException e) {
                        System.out.println("file not found");
                    }
					break;
					}
			case 3: {
					//choice3();
					System.out.println("3: Search Topics And Display Content");
					Display d = new Display();
					d.display();
					break;
					}
			default:System.out.println("Enter Proper choice");
		}
	} 

}

