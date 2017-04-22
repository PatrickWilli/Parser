package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLReader
{
	private String bufferedString;
	private Document xmldoc;

	public XMLReader(String bufferedString)
	{
            this.bufferedString = bufferedString;
            parse();
	}

	private void parse()
	{

		//URI uri = stringPathToURI(pathtoxml);

		try
		{
                   
                    DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
                    Document document = dBuilder.parse(bufferedString);
                    document.getDocumentElement().normalize();
                    setXMLDocument(document);
 
                    // return document;
		} catch (ParserConfigurationException e)
		{
			System.err.println("ParserConfiguratuionException: Something went terrible wrong!");
			e.printStackTrace();

		} catch (NullPointerException npe)
		{
			System.err.println("NullPointerException: Path was empty!");

		} catch (SAXException e)
		{
			System.err.println("SAXException: Cannot Parse File!");
			e.printStackTrace();

		} catch (IOException e)
		{
			System.err.println("IOException: Cannot Read File!");
			e.printStackTrace();
		}

	}

	private void setXMLDocument(Document xmldoc)
	{
		this.xmldoc = xmldoc;
	}

	private Document getXMLDocument()
	{
		return xmldoc;
	}

	public String getXMLDocumentAsString()
	{

		try
		{
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(getXMLDocument()), new StreamResult(writer));
			return writer.getBuffer().toString();
		} catch (TransformerConfigurationException e)
		{
			System.err.println("TransformerConfigurationException: Something went wrong while creating transformer Object");
			e.printStackTrace();
			return "-1";
		} catch (TransformerException e)
		{
			System.err.println("TransformerException: Something went wrong while Transforming xml to string!");
			e.printStackTrace();
			return "-1";
		}

	}
}
