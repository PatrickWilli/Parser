package parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class JSONtoXML
{
	private ArrayList<JSONObject> jsonobjects;
	
	public JSONtoXML(ArrayList<JSONObject> jsonobjects)
	{
		this.jsonobjects = jsonobjects;
	}
		
	public String jsontoxml()
	{
		String xml = "";
		
		for(JSONObject jsobj : jsonobjects)
		{
			xml += XML.toString(jsobj);
		}
		return xml;
	}
}
