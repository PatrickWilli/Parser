package parser;

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
