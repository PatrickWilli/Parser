package parser;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONReader
{
	private String pathtojson;
	private JSONArray jsonarray;
	ArrayList<JSONObject> jsonobjects;

	public JSONReader(String pathtojson)
	{
		this.pathtojson = pathtojson;
		parse();
	}

	private void parse()
	{
		try
		{
			JSONTokener tokener = new JSONTokener(URIParser.toURI(pathtojson).toURL().openStream());
			jsonobjects = new ArrayList<JSONObject>();
			//wenn JSON Array
			if(tokener.nextClean() == '[')
			{
				//Einen Schritt zurück, wegen nextClean();
				tokener.back();
				jsonarray = new JSONArray(tokener);
				for(int i = 0; i < jsonarray.length(); i++)
				{
					jsonobjects.add((JSONObject)jsonarray.get(i));
				}
				setJSONObjects(jsonobjects);
			}
			else
			{
				tokener.back();
				jsonobjects.add(new JSONObject(tokener));
				setJSONObjects(jsonobjects);
			}
		} 
		catch (MalformedURLException e)
		{
			System.err.println("MalformedURLException: Faild to parse URI to URL");
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			System.err.println("IOException: Cannot Read File");
			e.printStackTrace();
		}
	}
	
	private void setJSONObjects(ArrayList<JSONObject> objects)
	{
		this.jsonobjects = objects;
	}
	
	public ArrayList<JSONObject> getJSONObjects()
	{
		return jsonobjects;
	}
	
}
