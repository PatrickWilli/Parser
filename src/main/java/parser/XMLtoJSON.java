package parser;

import org.json.XML;
public class XMLtoJSON
{
    private String parsedXML;


    public XMLtoJSON(String parsedXML)
    {
        this.parsedXML = parsedXML;
    }

    public String xmltojson()
    {
        return XML.toJSONObject(parsedXML).toString();
    }
    
}
