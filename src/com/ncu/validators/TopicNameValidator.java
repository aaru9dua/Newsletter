package com.ncu.validators;
import java.io.*;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TopicNameValidator{
	public boolean topicNameValidator(String filename, String filetype){
		System.out.println("File name is: " +filename+  " and its type is " +filetype);
		boolean b;


		Properties prop = new Properties();
		FileInputStream input=null;
		String txtfilepath = "C:\\Users\\Aarushi\\Desktop\\newsletter\\text";
		String csvfilepath = "C:\\Users\\Aarushi\\Desktop\\newsletter\\csv";

		Logger logger = Logger.getLogger(TopicNameValidator.class);
		PropertyConfigurator.configure("C:\\Users\\Aarushi\\Desktop\\newsletter\\configs\\logger\\logger.properties");

		try{
			input = new FileInputStream("C:\\Users\\Aarushi\\Desktop\\newsletter\\configs\\constants\\exceptions.properties");	
			prop.load(input);
			EmptyTopicName(filename);
			TopicNameLength(filename);
			SpecialCharacter(filename);
			TopicNotAvailable(filename);
			TopicExists(filename); 
			if(filetype=="txt")
			{
				txtOnly(filename);
				TopicNotAvailable(csvfilepath+"\\"+filename);

			}
			else{
				csvOnly(filename);
				TopicExists(txtfilepath+"\\"+filename);
			}

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
		catch(TopicNotAvailable e)
		{
			logger.error("\n \n"+e+prop.getProperty("topicnotAvailableMessage")+"\n");
			return false;
		}
		catch(TopicAlreadyExists e)
		{
			logger.error("\n \n"+e+prop.getProperty("fileExistsMessage")+"\n");
			return false;
		}
		catch(InvalidExtensionException e)
		{
		  logger.error("\n \n"+e+prop.getProperty("invalidException")+"\n");
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
		String namelength=filename.split("\\.")[0];
		if(namelength.length()>fileLength)
			throw new TopicNameLengthException("Filename length is more than 10");	
	}
	private void SpecialCharacter(String filename)throws SpecialCharacterException{
        filename=filename.split("\\.")[0];
		Pattern patternGet =Pattern.compile("[@#$%&^(<)]");
		Matcher check =patternGet.matcher(filename);
		boolean finalvalue= check.find();		
		if(finalvalue == true)
			throw new SpecialCharacterException("Cannot use special characters");
	}

	private void TopicNotAvailable(String filename)throws TopicNotAvailable{
		File f= new File(filename);
		if(f.exists()==false)
	    throw new TopicNotAvailable("File is not available");

	}
	private void TopicExists(String filename)throws TopicAlreadyExists{
		File f=new File("./"+filename);
		if(f.exists()==true)
			throw new TopicAlreadyExists("This file already exists");
	}

	private void txtOnly(String filename) throws InvalidExtensionException{
		String [] name = filename.split("\\.");
		if(!name[1].equals("txt")==true)
			throw new InvalidExtensionException("Invalid extension is used");
	}

	private void csvOnly(String filename)throws InvalidExtensionException{
		String [] name = filename.split("\\.");
			if(!name[1].equals("csv")==true)
			throw new InvalidExtensionException("Invalid Extension is used");
	}
}





class testTopicNameValidator{
	public static void main(String[] args) {
		TopicNameValidator txtObject = new TopicNameValidator();

		boolean checkValidator = txtObject.topicNameValidator(" ","");
		System.out.println(checkValidator);

        checkValidator = txtObject.topicNameValidator(" ","txt");
        System.out.println(checkValidator);
	}
	
}