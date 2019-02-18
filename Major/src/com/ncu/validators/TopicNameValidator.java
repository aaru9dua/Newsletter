package com.ncu.validators;
import java.io.*;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TopicNameValidator{
	public boolean topicNameValidator(String filename){
		System.out.println("Topic name is: " +filename);
		boolean b;


		Properties prop = new Properties();
		FileInputStream input=null;
		String txtfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\Text";
		String csvfilepath = "C:\\Users\\Abhi\\Desktop\\Major\\csvs";

		Logger logger = Logger.getLogger(TopicNameValidator.class);
		//this is to import the logger property
		PropertyConfigurator.configure("C:\\Users\\Abhi\\Desktop\\Major\\configs\\logger\\logger.properties");

		//usage of try to find the exception

		try{
			input = new FileInputStream("C:\\Users\\Abhi\\Desktop\\Major\\configs\\constants\\exceptions.properties");	
			prop.load(input);
			EmptyTopicName(filename);
			TopicNameLength(filename);
			SpecialCharacter(filename);
			TopicExists(filename); 
		}
		catch(EmptyTopicName e){
			logger.error("\n \n"+e+prop.getProperty("emptyNameMessage")+"\n");
            return false; 
			
		}
	
		catch(TopicNameLengthException e)
		{
			logger.error("\n \n"+e+prop.getProperty("longFileNameMessage")+"\n");
			return false;
		}
		catch(SpecialCharacterException e)
		{
			logger.error("\n \n"+e+prop.getProperty("specialCharacterMessage")+"\n");
			return false;
		}
		catch(TopicAlreadyExists e)
		{
			logger.error("\n \n"+e+prop.getProperty("fileExistsMessage")+"\n");
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			return true;
    }

	private void EmptyTopicName(String filename)throws EmptyTopicName{
		if(filename== " ")
			throw new EmptyTopicName("emptyNameMessage");
	}

    private void TopicNameLength(String filename)throws TopicNameLengthException{
		int fileLength=10;
		
		if(filename.length()>fileLength)
			throw new TopicNameLengthException("Filename length is more than 10");	
	}
	private void SpecialCharacter(String filename)throws SpecialCharacterException{
    
		Pattern patternGet =Pattern.compile("[@#$%&^(<)]");
		Matcher check =patternGet.matcher(filename);
		boolean finalvalue= check.find();		
		if(finalvalue == true)
			throw new SpecialCharacterException("Cannot use special characters");

	}
	private void TopicExists(String filename)throws TopicAlreadyExists{
		File f=new File("./"+filename);
		if(f.exists()==true)
			throw new TopicAlreadyExists("This file already exists");
	}
}