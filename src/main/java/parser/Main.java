package parser;

public class Main
{
	public static void main(String[] args)
	{
		/*XMLReader xmlreader = new XMLReader("C:\\Users\\phamm\Desktop\xmltoparse.xml");
		XMLtoJSON xtoj = new XMLtoJSON(xmlreader.getXMLDocumentAsString());
		System.out.println(xtoj.xmltojson());*/
		
		JSONReader jsonreader = new JSONReader("C:\\Users\\phamm\\Downloads\\generated(1).json");
		JSONtoXML jtox = new JSONtoXML(jsonreader.getJSONObjects());
		System.out.println(jtox.jsontoxml());
	}
}
