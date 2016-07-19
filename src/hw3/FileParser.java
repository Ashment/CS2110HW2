package hw3;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {
	StringBuilder nameStringBuilder;
	public String parsedString;
	
	public String parseFile(String fileName) throws Exception{
		//Initialized and Reset
		nameStringBuilder = new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		parsedString = "";
		
		//Read and append to StringBuilder
		while((parsedString = in.readLine()) != null){
			nameStringBuilder.append(parsedString);
		}
		in.close();
		
		//Return Constructed String
		return nameStringBuilder.toString();
	}
}
