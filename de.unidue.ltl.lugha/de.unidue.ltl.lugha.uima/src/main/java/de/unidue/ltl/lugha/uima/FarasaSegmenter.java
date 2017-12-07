package de.unidue.ltl.lugha.uima;

import com.qcri.farasa.segmenter.Farasa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FarasaSegmenter {

	   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        
        List<String> output = segment("النص المراد معالجته");
        
           for(String s: output){
        	   System.out.println(s);
           }

     }
	   
	   public static List<String> segment(String line) throws IOException, FileNotFoundException, ClassNotFoundException {
		   
		   List<String> segmentedWords = new ArrayList<String> ();
		   
	        Farasa farasa = new Farasa();

	        segmentedWords = farasa.segmentLine("النص المراد معالجته");

	       
		   return segmentedWords;
	   }

	
}
