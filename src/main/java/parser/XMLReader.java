package parser;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLReader
{
	private String pathtoxml;
	private Document xmldoc;

	public XMLReader(String pathtoxml)
	{
		this.pathtoxml = pathtoxml;
		parse();
	}

	private void parse()
	{

		URI uri = stringPathToURI(pathtoxml);

		try
		{
			File xmlfile = new File(uri.toString());
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
			Document document = dBuilder.parse(xmlfile);
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

	public Document getXMLDocument()
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
			System.err.println(
					"TransformerConfigurationException: Something went wrong while creating transformer Object");
			e.printStackTrace();
			return "-1";
		} catch (TransformerException e)
		{
			System.err.println("TransformerException: Something went wrong while Transforming xml to string!");
			e.printStackTrace();
			return "-2";
		}

	}

	private URI stringPathToURI(String pathtoxml)
	{

		pathtoxml = pathtoxml.replace("\\", "/");

		try
		{

			return new URI(pathtoxml);

		} catch (URISyntaxException e)
		{
			System.err.println("Could not Parse Path (String) to URI");
			e.printStackTrace();
			return null;
		}

	}

}
