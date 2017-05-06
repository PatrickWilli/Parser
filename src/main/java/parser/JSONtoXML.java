package parser;

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.XML;
import parser.interfaces.Converter;

public class JSONtoXML implements Converter
{
	private ArrayList<JSONObject> jsonobjects;
        private String xml;
	
	public JSONtoXML(ArrayList<JSONObject> jsonobjects)
	{
		this.jsonobjects = jsonobjects;
	}
		
	public void convert()
        {
		xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + "<JSONtoXML>\n";
		for(JSONObject jsobj : jsonobjects)
		{
			xml += XML.toString(jsobj) + "\n";
		}
                xml += "</JSONtoXML>";
                setXMLString(xml);
	}
        
        private void setXMLString(String s)
        {
            this.xml = s;
        }
        
        public String getConvertedString()
        {
            return xml;
        }
}
