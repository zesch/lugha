package de.unidue.ltl.lugha.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class SimpleWriter {

	private Writer output;

	public void constructNewFile(List<String> lines, String fileName)
			throws IOException {
		
		 File file;


		try {

			file = new File(fileName);

			boolean found = file.exists();

			if (found == false) {

				output = new BufferedWriter(new FileWriter(file, true));

						for(String line: lines)
						writeToFile(line);


				output.flush();
				output.close();

			} else
				System.out
						.println("=====================File already exist!!!====================");

		} catch (IOException ioe) {

			new IOException();

		}

	}
	
	private void writeToFile(final String word) throws IOException {

		output.write(word);
		output.write(System.getProperty("line.separator"));
		
	}


}
