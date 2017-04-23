package parser;

import java.net.URI;


public class Main
{
    private static JSONReader jsonreader;
    private static XMLReader xmlreader;

    public static void main(String[] args)
    {
        /*XMLReader xmlreader = new XMLReader("C:\\Users\\phamm\\Desktop\\xmltoparse.xml");
        XMLtoJSON xtoj = new XMLtoJSON(xmlreader.getXMLDocumentAsString());
        System.out.println(xtoj.xmltojson());*/

        /*JSONReader jsonreader = new JSONReader("C:\\Users\\phamm\\Downloads\\generated(1).json");
        JSONtoXML jtox = new JSONtoXML(jsonreader.getJSONObjects());
        System.out.println(jtox.jsontoxml());*/
    }

    public static void start(String path)
    {
        URI uri = URIParser.toURI(path);
        if(uri.toString().startsWith("file:///"))
        {
            new LocalFileReader(uri);
        }
        else
        {
            new NetClient(uri);
        }
        
        switch(FormatDetector.getFileFormat())
        {
            case "json": 
                jsonreader = new JSONReader(Buffer.getBufferedString());
                break;
            case "xml":
                xmlreader = new XMLReader(Buffer.getBufferedString());
                break;
            case "unknown":
                break;
            default:
                break;
        }
        
        
    }
}
