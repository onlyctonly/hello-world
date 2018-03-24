package gr.cgw.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;

public class App 
{
    @SuppressWarnings({ "deprecation", "resource" })
	public static void main( String[] args )
    {
    	System.out.println("start");
    	PDDocument document = new PDDocument();
    	PDPage page = new PDPage();
    	document.addPage( page );

    	// Create a new font object selecting one of the PDF base fonts
    	PDFont font;

    	// Start a new content stream which will "hold" the to be created content
    	
		try {
			font = PDTrueTypeFont.loadTTF(document, new FileInputStream("c:/windows/fonts/Arial.ttf"));
			PDPageContentStream contentStream;
			contentStream = new PDPageContentStream(document, page);
	    	// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
	    	contentStream.beginText();
	    	contentStream.setFont(font, 12);
	    	contentStream.newLineAtOffset(0, 780);
	    	contentStream.showText("hello world!");
	    	contentStream.endText();

	    	// Make sure that the content stream is closed:
	    	contentStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    	// Save the results and ensure that the document is properly closed:
    	try {
			document.save( "Hello World.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	    	try {
				document.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	System.out.println("end");

    }
}
