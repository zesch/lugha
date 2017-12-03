package de.unidue.ltl.lugha.io;

import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.io.ResourceCollectionReaderBase;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;

public class MergeCorporaFiles {
	
	private String targetFileUri;
	private String sourceFolder;
	private String encoding;

	public static final String FILEPATH_TRAIN = "data/seq/seq.txt";

	public static String SOURCE_FOLDER = "/Users/ltl2014lf/Documents/DKPro";

	private File file;
	private Writer output;
	
	public MergeCorporaFiles(String fileUri, String sourceFolder, String encoding) {

		this.targetFileUri = fileUri;
		this.sourceFolder = sourceFolder;
		this.encoding = encoding;
	}
	
    public static void main(String[] args) throws IOException, ResourceInitializationException {
    	
//		  sourceFolder = baseDir + "/" + "data/tashkeela";
//		  sourceFolder = baseDir + "/" + "data/11books";
//		  sourceFolder = sourceFolder + "/" + "data/rdi";

		MergeCorporaFiles ucf = new MergeCorporaFiles(FILEPATH_TRAIN, SOURCE_FOLDER, "CP1256");			
		ucf.constructNewFile(true, false);
		
    }

	private void dumpMetaData(final DocumentMetaData aMetaData) {
//		System.out.println("Collection ID: " + aMetaData.getCollectionId());
//		System.out.println("ID           : " + aMetaData.getDocumentId());
//		System.out.println("Base URI     : " + aMetaData.getDocumentBaseUri());
		System.out.println("URI          : " + aMetaData.getDocumentUri());
	}

	public void constructNewFile(boolean isLine, boolean isXML) throws ResourceInitializationException,
			IOException {

		try {

			file = new File(targetFileUri);
			
			 boolean found = file.exists();
			 
			if( found == false ){
	        	 
	 			output = new BufferedWriter(new FileWriter(file, true));
	 			
	 			//TextReader.class: reads the document as one object.
	 			CollectionReaderDescription reader = createReaderDescription(
	 					TextReader.class,
	 					ResourceCollectionReaderBase.PARAM_SOURCE_LOCATION, sourceFolder, 
	 					ResourceCollectionReaderBase.PARAM_PATTERNS, "[+]*.html",
	 					TextReader.PARAM_ENCODING, encoding);
	 			
	 			int sent = 1;
	 			for (JCas jcas : new JCasIterable(reader)) {

	 				DocumentMetaData md = DocumentMetaData.get(jcas);
	 				dumpMetaData(md);
	 				
	 				String doc = jcas.getDocumentText();
	 				
	 				if (isLine) {
	 					if(isXML){
	 						for (String sentence : doc.split("\n"))
	 							writeToFile("<in_seg id=\"SENT" + sent++ +"\">"+sentence+"</in_seg>");
	 					}else
	 						writeToFile(doc);	
	 				} else {
	 					for (String token : doc.split(" ")) {
	 						writeToFile(token);
	 					}
	 				}
	 				
	 				sent++;

	 			}

	 			output.flush();
	 			output.close();

	         }else
	        	 System.out.println("========================================File already exist!!!========================================");

		} catch (IOException ioe) {

			new IOException();

		}

	}

	private void writeToFile(final String word) throws IOException {

		output.write(word);
		output.write(System.getProperty("line.separator"));
		
	}
	

}
