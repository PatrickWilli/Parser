package parser.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import parser.util.Buffer;
import parser.interfaces.Reader;

public class XMLReader implements Reader
{
	private String bufferedString;
	private Document xmldoc;

	public XMLReader(String bufferedString)
	{
            this.bufferedString = bufferedString;
            read();
	}

	public void read()
	{
		try
		{
                   
                    DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
                    InputSource is = new InputSource(new StringReader(bufferedString));
                    Document document = dBuilder.parse(is);
                    document.getDocumentElement().normalize();
                    setXMLDocument(document);
                    setXMLDocumentAsString();
		} 
                catch (ParserConfigurationException e)
		{
			System.err.println("ParserConfiguratuionException: Something went terrible wrong!");
			e.printStackTrace();

		} 
                catch (NullPointerException e)
		{
			System.err.println("NullPointerException: Path was empty!");
                        e.printStackTrace();

		} 
                catch (SAXException e)
		{
			System.err.println("SAXException: Cannot Parse File!");
			e.printStackTrace();

		} 
                catch (IOException e)
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

	private void setXMLDocumentAsString()
	{

		try
		{
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(getXMLDocument()), new StreamResult(writer));
			Buffer.setXMLString(writer.getBuffer().toString());
		} catch (TransformerConfigurationException e)
		{
			System.err.println("TransformerConfigurationException: Something went wrong while creating transformer Object");
			e.printStackTrace();
		} catch (TransformerException e)
		{
			System.err.println("TransformerException: Something went wrong while Transforming xml to string!");
			e.printStackTrace();
		}

	}
}
