/**
 * @author Jacob Watters
 */

package water.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileManager {
	
	
	/**
	 * Writes content to file
	 * 
	 * @param filePath - file path
	 * @param content - content to be written to file
	 */
	public static void writeFile(String filePath, String content) {
		try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
        		System.err.println("Error: Could Not Write To File");
            e.printStackTrace();
        }
	}
	
	
	 /**
	  * Reads and returns contents of file as string
	  * 
	  * @param filePath - file path including extension
	  * @return String - contents of file
	  */
	public static String readFile(String filePath) {
		 StringBuilder contentBuilder = new StringBuilder();
		 
	        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
	            stream.forEach(s -> contentBuilder.append(s).append("\n"));
	        }
	        catch (IOException e) {
	        		System.err.println("Error: Could Not Read File");
	            e.printStackTrace();
	        }
	 
	        return contentBuilder.toString();
	}
	
	/**
	 * Reads and returns contents of file as array
	 * 
	 * @param filePath - file path including extension
	 * @return String[] - array containing lines of content file
	 */
	public static String[] readFileToArray(String filePath) {
		Scanner sc;
		String[] arr = null;
		
		try {
			sc = new Scanner(new File(filePath));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			}

			arr = lines.toArray(new String[0]);
			
		} catch (FileNotFoundException e) {
			System.err.println("Error: Could Not Read File");
			e.printStackTrace();
		}
		
		return arr;
	}
	
	
	/**
	 * Converts a plain text file to a .csv file. Commas will be inserted at all spaces and lines will be preserved.
	 * The .csv file will be output in same directory and with the same name as the text file. 
	 * 
	 * @param filePath - file path including extension
	 */
	public static void txt2csv(String filePath) {
		try {
			if(filePath.substring(filePath.length()-3, filePath.length()).equals(".txt")) {
				String csvContent = readFile(filePath).replaceAll(" ", ", ");	
				filePath = filePath.replace(".txt", ".csv");
				
				writeFile(filePath, csvContent);
			}
			else {
				throw new Exception();
			}
		} catch(Exception e) {
			System.err.println("Error: file extension must be .txt");
		}
	}
	
	
	/**
	 * Method not implemented
	 * 
	 * @return null
	 */
	public static String[] csv2array() {
		return null;
	}
}
