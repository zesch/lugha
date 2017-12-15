package de.unidue.ltl.lugha.io;


import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class MergeCorporaFilesTest {

//	public static final String targetFileUri = "src/test/resources/seq/seq.txt";
//	public static final String sourceFolder = "src/test/resources/ar/rdim";

	public static final String targetFileUri = "src/test/seq/KACST.txt";
	
	public static final String sourceFolder = "/Users/ltl2014lf/Downloads/main-paper/Arabic-Newspapers";

	@Test
	public void testMergeCorporaFiles() throws Exception {
		
		MergeCorporaFiles ucf = new MergeCorporaFiles(targetFileUri, sourceFolder, "UTF-8");//UTF-8, CP1256
        
		//Merge corpora files
//		ucf.constructNewFile(true, false);
		
		//MADAMIRA sentences in xml format
		ucf.constructNewFile(true, false);//default false
		
		File file = new File(targetFileUri);
		boolean found = file.exists();
		 
		 
		if(found)
        {
           System.out.println("================================+++File already exist!!!+++================================");
           
        }
		
		assertEquals(true, found);
		
	}


}
