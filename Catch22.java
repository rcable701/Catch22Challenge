/**
 * 
 */
package filereading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author rebec
 *
 */
public class Catch22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	File file = new File("Catch 22.txt");
	File redacted = new File("Catch22Redacted.txt");
	
	String line;
	int numberOfLines, numberOfWords, numberOfChars, yossarian, aCount, catch22Count; 
	
	// Possible Challeneges
	// Output the text to screen
	// Number of lines in the text
	// How many times is the main character "Yossarian" mentioned
	// How many times is Catch 22 mentioned
	// Number of 'a's
	// Most frequently used letter
	
	numberOfLines = 0;
	numberOfWords = 0;
	numberOfChars = 0;
	yossarian = 0;
	aCount = 0;
	catch22Count = 0;
	
	try {
		
		// getting the file to read
		FileReader fileReader = new FileReader(file.getName());
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// Organising file to write to
		FileWriter fileWriter = new FileWriter(redacted.getName());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		line = bufferedReader.readLine();
		
		while(line != null) {
			
			System.out.println(line);
			numberOfChars += line.length();
			numberOfLines++;
			
			// number of Words in the line
			String[] words = line.split(" ");
			numberOfWords += words.length;
			
			// finding instances of "Yossarian"
			if(line.contains("Yossarian")) {
				yossarian++;
				
				// String redact with ---------
				
				String redactLine = line.replace("Yossarian", "---------");
				bufferedWriter.write(redactLine + "\n"); 
				
			} else {
				
				bufferedWriter.write(line + "\n");
				
			}
			
			// How many times has Catch 22 been mentioned
			if(line.contains("Catch-22")) {
				
				catch22Count++;
				
			}
			
			
			char c; 
			// how many vowels
			for(int loop = 0; loop < line.length(); loop++) {
				
				switch (line.charAt(loop)) {
				case 'a': 
				case 'A': 
					aCount++;
					break;
				default: 
					
				}
			}
			
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		fileReader.close();
		
		bufferedWriter.close();
		bufferedReader.close();
		
		System.out.println("Number of lines : " + numberOfLines);
		System.out.println("Number of words : " + numberOfWords);
		System.out.println("Number of Chars : " + numberOfChars);
		System.out.println("Number of Yossarian : " + yossarian);
		System.out.println("Number of Catch 22 : " + catch22Count);
		System.out.println("Number of 'a's : " + aCount);
		
	} catch (FileNotFoundException e) {
		
		System.out.println("Can't find the book");
		
	} catch (IOException e) {
		
		System.out.println("Oops... Input Output issue!");
		
	}
		
		
	}

}
