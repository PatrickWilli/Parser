package parser;

import parser.datafetcher.LocalFileReader;
import parser.datafetcher.NetClient;
import parser.util.Buffer;
import parser.util.FormatDetector;
import parser.util.URIParser;
import parser.xml.XMLReader;
import parser.json.JSONReader;
import java.net.URI;


public class Main
{

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
                new JSONReader(Buffer.getBufferedString()).read();
                break;
            case "xml":
                new XMLReader(Buffer.getBufferedString()).read();
                break;
            case "unknown":
                break;
            default:
                break;
        }
    }
}
