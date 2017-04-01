package parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;
import org.json.JSONWriter;

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
			JSONTokener tokener = new JSONTokener(stringPathToURI(pathtojson).toURL().openStream());
			jsonobjects = new ArrayList();
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
	
	private void setJSONObjects(ArrayList objects)
	{
		this.jsonobjects = objects;
	}
	
	public ArrayList<JSONObject> getJSONObjects()
	{
		return jsonobjects;
	}
	private URI stringPathToURI(String pathtojson)
	{

		pathtojson = pathtojson.replace("\\", "/");

		try
		{
			if(pathtojson.contains("http"))
			{
				return new URI(pathtojson);
			}
			else
			{
				return new URI("file:///"+pathtojson);
			}
		} 
		catch (URISyntaxException e)
		{
			System.err.println("Could not Parse Path (String) to URI");
			e.printStackTrace();
			return null;
		}

	}
}
