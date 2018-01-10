package de.unidue.ltl.lugha.io;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class SimpleReader {

	public static List<String> readFile(String fileName) throws Exception{
		
		List<String> list = FileUtils.readLines(new File(fileName));
				
		return list;
	}
	
}