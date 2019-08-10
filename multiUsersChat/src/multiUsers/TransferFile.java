package multiUsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TransferFile {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		BufferedReader inputFile= new BufferedReader(new FileReader("/home/bca3/aryan.pdf"));
		PrintWriter outputFile= new PrintWriter(new FileWriter(new File("/home/bca3/aryan1.pdf")));
		
		int c2= 0;
		while((c2= inputFile.read()) != -1)
		{
			outputFile.print((char)c2);
			outputFile.flush();
			//System.out.println((char)c2);
		}
	}
}
