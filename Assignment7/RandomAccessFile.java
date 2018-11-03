import java.io.*;
import java.util.Scanner;

public class RandomAccessFile{
	
	public Scanner randomAccess(File file) throws Exception {
		Scanner sc = new Scanner(file);
		return sc;
	}
	
	
	public static void parse(File file) throws Exception {
	   RandomAccessFile ra = new RandomAccessFile();
	   Scanner input = null;
	   try {
	       input = ra.randomAccess(file);
	       while (input.hasNextLine()) {
	    	   System.out.println(input.nextLine()); 
	       }
	       return;
	   } finally {
	       if (input != null) {
	           input.close();
	       }
	   }
	}
	
	public static void main(String[] args) throws Exception {
		File file = new File("src/test.txt");
		RandomAccessFile.parse(file);
	}
  
}
