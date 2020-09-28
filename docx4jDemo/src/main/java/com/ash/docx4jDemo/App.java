package com.ash.docx4jDemo;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			//createDocxFile();
			readDocxFile();
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void createDocxFile() throws Docx4JException {
    	WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
    	MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
    	mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
    	mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
    	File exportFile = new File("welcome.docx");
    	wordPackage.save(exportFile);
    }
    public static void readDocxFile() throws Docx4JException, JAXBException {
    	File doc = new File("welcome.docx");
    	WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
    	  .load(doc);
    	MainDocumentPart mainDocumentPart = wordMLPackage
    	  .getMainDocumentPart();
    	String textNodesXPath = "//w:t";
    	List<Object> textNodes= mainDocumentPart
    	  .getJAXBNodesViaXPath(textNodesXPath, true);
    	for (Object obj : textNodes) {
    	    Text text = (Text) ((JAXBElement) obj).getValue();
    	    String textValue = text.getValue();
    	    System.out.println(textValue);
    	}
    }
}
