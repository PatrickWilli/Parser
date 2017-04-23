package parser;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.XML;

public class JSONtoXML
{
	private ArrayList<JSONObject> jsonobjects;
        private String xml = "";
	
	public JSONtoXML(ArrayList<JSONObject> jsonobjects)
	{
		this.jsonobjects = jsonobjects;
                jsontoxml();
	}
		
	private void jsontoxml()
	{
		
		
		for(JSONObject jsobj : jsonobjects)
		{
			xml += XML.toString(jsobj) + "\n";
                        
                        System.out.println(xml);
		}	
                setXMLString(xml);
                
	}
        
        private void setXMLString(String xml)
        {
            this.xml = xml;
        }
        
        public String getXMLString()
        {
            return xml;
        }
}
