package parser;

import org.json.XML;
import parser.interfaces.Converter;

public class XMLtoJSON implements Converter
{
    private String xml;
    private String jsonstring;

    public XMLtoJSON(String xml)
    {
        this.xml = xml;
    }

    public void convert()
    {
         setJsonString(XML.toJSONObject(xml).toString());
    }
    
    private void setJsonString(String jsonstring)
    {
        this.jsonstring = jsonstring;
    }
    public String getConvertedString()
    {
        return jsonstring;
    }
    
    
}
