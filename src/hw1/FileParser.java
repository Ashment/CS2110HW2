package hw1;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {
	StringBuilder numberStringBuilder;
	public String parsedString;
	
	public String parseFile(String fileName) throws Exception{
		//Initialized and Reset
		numberStringBuilder = new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		parsedString = "";
		
		//Read and append to StringBuilder
		while((parsedString = in.readLine()) != null){
			numberStringBuilder.append(parsedString);
		}
		in.close();
		
		//Return Constructed String
		return numberStringBuilder.toString();
	}
}
